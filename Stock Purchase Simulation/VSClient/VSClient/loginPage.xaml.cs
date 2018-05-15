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
    public sealed partial class loginPage : Page
    {
        StockMarketWebService.PurchaseSharesClient client;
        private async void displayMessageBox(String output)
        {
            var messageDialog = new Windows.UI.Popups.MessageDialog(output);
            messageDialog.Commands.Add(new UICommand("OK", (command) => { }));
            await messageDialog.ShowAsync();
        }
        public loginPage()
        {
            this.InitializeComponent();
        }

        private void btnLogin_Click(object sender, RoutedEventArgs e)
        {
            client = new StockMarketWebService.PurchaseSharesClient();
            Boolean success = client.userLoginAsync(txtUsername.Text,txtPassword.Password).Result.@return;
            if (success == false){
                displayMessageBox("Username and / or password mismatch");
            } else
            {
                //CreateShares createShares = new CreateShares();


                this.Frame.Navigate(new CreateShares().GetType(), null);
            }

        }

        private void btnCreateUser_Click(object sender, RoutedEventArgs e)
        {
            client = new StockMarketWebService.PurchaseSharesClient();
            Boolean success = client.addUserAsync(txtUsername.Text, txtPassword.Password, txtFirstName.Text).Result.@return;
            if (success == false)
            {
                displayMessageBox("Username already exists");
            } else
            {
                displayMessageBox("User Creation successful");
                txtUsername.Text = "";
                txtPassword.Password = "";
                txtFirstName.Text = "";
            }
        }
    }
}
