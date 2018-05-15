using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using Windows.Foundation;
using Windows.Foundation.Collections;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;

// The Blank Page item template is documented at https://go.microsoft.com/fwlink/?LinkId=234238

namespace VSClient
{
    /// <summary>
    /// An empty page that can be used on its own or navigated to within a Frame.
    /// </summary>
    public sealed partial class CreateShares : Page
    {
        StockMarketWebService.PurchaseSharesClient client = new StockMarketWebService.PurchaseSharesClient();
        private async void displayMessageBox(String output)
        {
            var messageDialog = new Windows.UI.Popups.MessageDialog(output);
            messageDialog.Commands.Add(new UICommand("OK", (command) => { }));
            await messageDialog.ShowAsync();
        }

        public CreateShares()
        {
            this.InitializeComponent();

            

        }

        private void btnLogin_Click(object sender, RoutedEventArgs e)
        {
            Boolean success = client.addStockAsync(txtCompanyName.Text.ToString(), txtSymbol.Text.ToString(), Int32.Parse(txtVolume.Text), Double.Parse(txtValue.Text)).Result.@return;
            
            if (success == true)
            {
                displayMessageBox("Stock successfully created");
            } else
            {
                displayMessageBox("Stock already exists");
            }
        }

        private void btnGoHome_Click(object sender, RoutedEventArgs e)
        {
            this.Frame.Navigate(new MainPage().GetType(), null);
        }
    }
}
