using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using Windows.Foundation;
using Windows.Foundation.Collections;
using Windows.System.Threading;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;


// The Blank Page item template is documented at https://go.microsoft.com/fwlink/?LinkId=402352&clcid=0x409

namespace VSClient
{
    /// <summary>
    /// An empty page that can be used on its own or navigated to within a Frame.
    /// </summary>
    public sealed partial class MainPage : Page
    {
        StockMarketWebService.PurchaseSharesClient client;
        StockMarketWebService.companyShare[] companyShares;
        
        private int getSortValue()
        {
            int sortValue = 0;

            if (rbHLP.IsChecked == true)
            {
                sortValue = 1;
            }
            else if (rbLHP.IsChecked == true)
            {
                sortValue = 0;
            }
            else if (rbAlpha.IsChecked == true)
            {
                sortValue = 2;
            }
            return sortValue;

        }
        private void loadShares(String filtervalue, String currencyType, int sortType)
        {
            client = new StockMarketWebService.PurchaseSharesClient();
            lstVwShares.ItemsSource = null;
            clearfields();

            Char[] currency = currencyType.ToCharArray();
            currencyType = currency[0].ToString() + currency[1] + currency[2];
            if (filtervalue == "") { filtervalue = null; }

            companyShares = client.getSharesAsync(filtervalue, currencyType).Result.@return;

            StockMarketWebService.companyShare tempShare = new StockMarketWebService.companyShare();


            for (int i = 0; i < companyShares.Length; i++)
            {
                for (int x = 1; x < (companyShares.Length - i); x++)
                {
                    if (sortType == 0)
                    {
                        if (companyShares[x - 1].sharePrice.value > companyShares[x].sharePrice.value)
                        {
                            tempShare = companyShares[x - 1];
                            companyShares[x - 1] = companyShares[x];
                            companyShares[x] = tempShare;
                        }
                    }
                    else if (sortType == 1)
                    {
                        if (companyShares[x - 1].sharePrice.value < companyShares[x].sharePrice.value)
                        {
                            tempShare = companyShares[x - 1];
                            companyShares[x - 1] = companyShares[x];
                            companyShares[x] = tempShare;
                        }
                    }
                }
            }
            List<CompanyStock> allCompanyStock = new List<CompanyStock>();

            foreach (StockMarketWebService.companyShare share in companyShares)
            {
                allCompanyStock.Add(new CompanyStock
                {
                    companyName = share.companyName,
                    symbol = share.companySymbol,
                    volume = share.numOfAvailShares,
                    currency = share.sharePrice.currency,
                    value = share.sharePrice.value,
                    date = share.sharePrice.dateOfLastUpdate
                });

            }

                
            lstVwShares.ItemsSource = allCompanyStock;


            //var loopIndex = 10;
            //await ThreadPool.RunAsync(
            //      o =>
            //      {
            //          // This is a background operation!
            //          while (true)
            //          {
            //              client = new StockMarketWebService.PurchaseSharesClient();

            //              lstBxShares.Items.Clear();
            //              //StockMarketWebService.getCurrencyNamesResponse x = await client.getSharesAsync(null, null).Result;
            //              foreach (StockMarketWebService.companyShare company in client.getSharesAsync(null, null).Result.@return)
            //              {
            //                  lstBxShares.Items.Add(company.companyName);

            //              }
            //              System.Threading.Tasks.Task.Delay(2000);
            //          }
            //      });
        }

        private void clearfields()
        {
            //lblCName.Text = "";
            //txtCompanyName.Text = "";
            //lblSymbol.Text = "";
            //lblVolume.Text = "";
            //lblShareCurrency.Text = "";
            //lblPrice.Text = "";
            //lblLastUpdated.Text = "";
            txtSharesWanted.Text = "0";
            lstVwShares.SelectedIndex = -1;
        }

        private async void displayMessageBox(String output)
        {
            var messageDialog = new Windows.UI.Popups.MessageDialog(output);
            messageDialog.Commands.Add(new UICommand("OK", (command) => { }));
            await messageDialog.ShowAsync();
        }

        private async void Wait()
        {
            await System.Threading.Tasks.Task.Delay(TimeSpan.FromSeconds(10));

        }

        public MainPage()
        {
            this.InitializeComponent();


            //client = new StockMarketWebService.PurchaseSharesClient();
            //lstBxShares.Items.Clear();
            //foreach (StockMarketWebService.companyShare company in client.getSharesAsync(null, null).Result.@return)
            //{
            //    lstBxShares.Items.Add(company.companyName);

            //}
            try
            {
                loadShares(null, "GBP", getSortValue());
                client = new StockMarketWebService.PurchaseSharesClient();

                String[] currencyTypes = client.getCurrencyNamesAsync().Result.@return;
                foreach (String currency in currencyTypes)
                {
                    cbxCurrency.Items.Add(currency);
                }
                cbxCurrency.SelectedIndex = 0;
            }
            catch (Exception ex)
            {
                displayMessageBox("Not connected to the Stock Exchange Web Service");
                //Wait();
                //App.Current.Exit();
            }

        }

        private void btnBuy_Click(object sender, RoutedEventArgs e)
        {
            client = new StockMarketWebService.PurchaseSharesClient();
            String output = "";

            if ((txtCompanyName.Text.ToString() != null) && (txtSharesWanted.Text.ToString() != null))
            {
                output = client.buySharesAsync(txtCompanyName.Text.ToString(), Int32.Parse(txtSharesWanted.Text.ToString())).Result.@return.ToString();
                loadShares(txtFilter.Text, cbxCurrency.SelectedItem.ToString(), getSortValue());
                clearfields();
            }
            else
            {
                output = "Please select a company and input the shares required";
            }

            displayMessageBox(output);

        }

        private void btnFilter_Click(object sender, RoutedEventArgs e)
        {

            loadShares(txtFilter.Text, cbxCurrency.SelectedItem.ToString(), getSortValue());

        }

        private void btnLogin_Click(object sender, RoutedEventArgs e)
        {
            //loginPage loginpage = new loginPage();
            //var host = new Window();
            //host.Content = loginPage;
            //host.Show();

            this.Frame.Navigate(new loginPage().GetType(), null);

            //Server.Transfer("Page2.aspx", true);
        }

        private void lstVwShares_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            client = new StockMarketWebService.PurchaseSharesClient();

            //StockMarketWebService.companyShare[] companyShares = companyShares;

            if (lstVwShares.SelectedIndex >= 0)
            {
                int i = lstVwShares.SelectedIndex;

                txtCompanyName.Text = companyShares[i].companyName.ToString();
 
            }
        }
    }
}
