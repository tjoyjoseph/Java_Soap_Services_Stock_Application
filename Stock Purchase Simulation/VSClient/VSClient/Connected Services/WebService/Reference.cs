﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

// 
// This code was auto-generated by Microsoft.VisualStudio.ServiceReference.Platforms, version 15.0.27130.2020
// 
namespace VSClient.WebService {
    
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.7.2612.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://shares.me.org/")]
    public partial class IOException : object, System.ComponentModel.INotifyPropertyChanged {
        
        private string messageField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=0)]
        public string message {
            get {
                return this.messageField;
            }
            set {
                this.messageField = value;
                this.RaisePropertyChanged("message");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.7.2612.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.Xml.Serialization.XmlTypeAttribute(TypeName="IOException", Namespace="http://DOCwebServices/")]
    public partial class IOException1 : object, System.ComponentModel.INotifyPropertyChanged {
        
        private string messageField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=0)]
        public string message {
            get {
                return this.messageField;
            }
            set {
                this.messageField = value;
                this.RaisePropertyChanged("message");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.7.2612.0")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://DOCwebServices/")]
    public partial class ParseException : object, System.ComponentModel.INotifyPropertyChanged {
        
        private int errorTypeField;
        
        private string messageField;
        
        private int positionField;
        
        private object unexpectedObjectField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=0)]
        public int errorType {
            get {
                return this.errorTypeField;
            }
            set {
                this.errorTypeField = value;
                this.RaisePropertyChanged("errorType");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=1)]
        public string message {
            get {
                return this.messageField;
            }
            set {
                this.messageField = value;
                this.RaisePropertyChanged("message");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=2)]
        public int position {
            get {
                return this.positionField;
            }
            set {
                this.positionField = value;
                this.RaisePropertyChanged("position");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=3)]
        public object unexpectedObject {
            get {
                return this.unexpectedObjectField;
            }
            set {
                this.unexpectedObjectField = value;
                this.RaisePropertyChanged("unexpectedObject");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(Namespace="http://shares.me.org/", ConfigurationName="WebService.PurchaseShares")]
    public interface PurchaseShares {
        
        [System.ServiceModel.OperationContractAttribute(Action="http://shares.me.org/PurchaseShares/getFnameRequest", ReplyAction="http://shares.me.org/PurchaseShares/getFnameResponse")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        System.Threading.Tasks.Task<VSClient.WebService.getFnameResponse> getFnameAsync(VSClient.WebService.getFnameRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://shares.me.org/PurchaseShares/addStockRequest", ReplyAction="http://shares.me.org/PurchaseShares/addStockResponse")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        System.Threading.Tasks.Task<VSClient.WebService.addStockResponse> addStockAsync(VSClient.WebService.addStockRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://shares.me.org/PurchaseShares/userLoginRequest", ReplyAction="http://shares.me.org/PurchaseShares/userLoginResponse")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        System.Threading.Tasks.Task<VSClient.WebService.userLoginResponse> userLoginAsync(VSClient.WebService.userLoginRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://shares.me.org/PurchaseShares/buySharesRequest", ReplyAction="http://shares.me.org/PurchaseShares/buySharesResponse")]
        [System.ServiceModel.FaultContractAttribute(typeof(VSClient.WebService.IOException), Action="http://shares.me.org/PurchaseShares/buyShares/Fault/IOException", Name="IOException")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        System.Threading.Tasks.Task<VSClient.WebService.buySharesResponse> buySharesAsync(VSClient.WebService.buySharesRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://shares.me.org/PurchaseShares/getSharesRequest", ReplyAction="http://shares.me.org/PurchaseShares/getSharesResponse")]
        [System.ServiceModel.FaultContractAttribute(typeof(VSClient.WebService.IOException), Action="http://shares.me.org/PurchaseShares/getShares/Fault/IOException", Name="IOException")]
        [System.ServiceModel.FaultContractAttribute(typeof(VSClient.WebService.IOException1), Action="http://shares.me.org/PurchaseShares/getShares/Fault/IOException_Exception", Name="IOException", Namespace="http://DOCwebServices/")]
        [System.ServiceModel.FaultContractAttribute(typeof(VSClient.WebService.ParseException), Action="http://shares.me.org/PurchaseShares/getShares/Fault/ParseException_Exception", Name="ParseException", Namespace="http://DOCwebServices/")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        System.Threading.Tasks.Task<VSClient.WebService.getSharesResponse> getSharesAsync(VSClient.WebService.getSharesRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://shares.me.org/PurchaseShares/getCurrencyNamesRequest", ReplyAction="http://shares.me.org/PurchaseShares/getCurrencyNamesResponse")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        System.Threading.Tasks.Task<VSClient.WebService.getCurrencyNamesResponse> getCurrencyNamesAsync(VSClient.WebService.getCurrencyNamesRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://shares.me.org/PurchaseShares/addUserRequest", ReplyAction="http://shares.me.org/PurchaseShares/addUserResponse")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        System.Threading.Tasks.Task<VSClient.WebService.addUserResponse> addUserAsync(VSClient.WebService.addUserRequest request);
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="getFname", WrapperNamespace="http://shares.me.org/", IsWrapped=true)]
    public partial class getFnameRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://shares.me.org/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string username;
        
        public getFnameRequest() {
        }
        
        public getFnameRequest(string username) {
            this.username = username;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="getFnameResponse", WrapperNamespace="http://shares.me.org/", IsWrapped=true)]
    public partial class getFnameResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://shares.me.org/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string @return;
        
        public getFnameResponse() {
        }
        
        public getFnameResponse(string @return) {
            this.@return = @return;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="addStock", WrapperNamespace="http://shares.me.org/", IsWrapped=true)]
    public partial class addStockRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://shares.me.org/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string name;
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://shares.me.org/", Order=1)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string symbol;
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://shares.me.org/", Order=2)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public int volume;
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://shares.me.org/", Order=3)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public int value;
        
        public addStockRequest() {
        }
        
        public addStockRequest(string name, string symbol, int volume, int value) {
            this.name = name;
            this.symbol = symbol;
            this.volume = volume;
            this.value = value;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="addStockResponse", WrapperNamespace="http://shares.me.org/", IsWrapped=true)]
    public partial class addStockResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://shares.me.org/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public bool @return;
        
        public addStockResponse() {
        }
        
        public addStockResponse(bool @return) {
            this.@return = @return;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="userLogin", WrapperNamespace="http://shares.me.org/", IsWrapped=true)]
    public partial class userLoginRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://shares.me.org/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string username;
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://shares.me.org/", Order=1)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string password;
        
        public userLoginRequest() {
        }
        
        public userLoginRequest(string username, string password) {
            this.username = username;
            this.password = password;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="userLoginResponse", WrapperNamespace="http://shares.me.org/", IsWrapped=true)]
    public partial class userLoginResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://shares.me.org/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public bool @return;
        
        public userLoginResponse() {
        }
        
        public userLoginResponse(bool @return) {
            this.@return = @return;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="buyShares", WrapperNamespace="http://shares.me.org/", IsWrapped=true)]
    public partial class buySharesRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://shares.me.org/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string companyName;
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://shares.me.org/", Order=1)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public int sharesWanted;
        
        public buySharesRequest() {
        }
        
        public buySharesRequest(string companyName, int sharesWanted) {
            this.companyName = companyName;
            this.sharesWanted = sharesWanted;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="buySharesResponse", WrapperNamespace="http://shares.me.org/", IsWrapped=true)]
    public partial class buySharesResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://shares.me.org/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string @return;
        
        public buySharesResponse() {
        }
        
        public buySharesResponse(string @return) {
            this.@return = @return;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="getShares", WrapperNamespace="http://shares.me.org/", IsWrapped=true)]
    public partial class getSharesRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://shares.me.org/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public int arg0;
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://shares.me.org/", Order=1)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string arg1;
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://shares.me.org/", Order=2)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string arg2;
        
        public getSharesRequest() {
        }
        
        public getSharesRequest(int arg0, string arg1, string arg2) {
            this.arg0 = arg0;
            this.arg1 = arg1;
            this.arg2 = arg2;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="getSharesResponse", WrapperNamespace="http://shares.me.org/", IsWrapped=true)]
    public partial class getSharesResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://shares.me.org/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute("return", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string[] @return;
        
        public getSharesResponse() {
        }
        
        public getSharesResponse(string[] @return) {
            this.@return = @return;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="getCurrencyNames", WrapperNamespace="http://shares.me.org/", IsWrapped=true)]
    public partial class getCurrencyNamesRequest {
        
        public getCurrencyNamesRequest() {
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="getCurrencyNamesResponse", WrapperNamespace="http://shares.me.org/", IsWrapped=true)]
    public partial class getCurrencyNamesResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://shares.me.org/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute("return", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string[] @return;
        
        public getCurrencyNamesResponse() {
        }
        
        public getCurrencyNamesResponse(string[] @return) {
            this.@return = @return;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="addUser", WrapperNamespace="http://shares.me.org/", IsWrapped=true)]
    public partial class addUserRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://shares.me.org/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string username;
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://shares.me.org/", Order=1)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string password;
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://shares.me.org/", Order=2)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public string firstname;
        
        public addUserRequest() {
        }
        
        public addUserRequest(string username, string password, string firstname) {
            this.username = username;
            this.password = password;
            this.firstname = firstname;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="addUserResponse", WrapperNamespace="http://shares.me.org/", IsWrapped=true)]
    public partial class addUserResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://shares.me.org/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public bool @return;
        
        public addUserResponse() {
        }
        
        public addUserResponse(bool @return) {
            this.@return = @return;
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface PurchaseSharesChannel : VSClient.WebService.PurchaseShares, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class PurchaseSharesClient : System.ServiceModel.ClientBase<VSClient.WebService.PurchaseShares>, VSClient.WebService.PurchaseShares {
        
        /// <summary>
        /// Implement this partial method to configure the service endpoint.
        /// </summary>
        /// <param name="serviceEndpoint">The endpoint to configure</param>
        /// <param name="clientCredentials">The client credentials</param>
        static partial void ConfigureEndpoint(System.ServiceModel.Description.ServiceEndpoint serviceEndpoint, System.ServiceModel.Description.ClientCredentials clientCredentials);
        
        public PurchaseSharesClient() : 
                base(PurchaseSharesClient.GetDefaultBinding(), PurchaseSharesClient.GetDefaultEndpointAddress()) {
            this.Endpoint.Name = EndpointConfiguration.PurchaseSharesPort.ToString();
            ConfigureEndpoint(this.Endpoint, this.ClientCredentials);
        }
        
        public PurchaseSharesClient(EndpointConfiguration endpointConfiguration) : 
                base(PurchaseSharesClient.GetBindingForEndpoint(endpointConfiguration), PurchaseSharesClient.GetEndpointAddress(endpointConfiguration)) {
            this.Endpoint.Name = endpointConfiguration.ToString();
            ConfigureEndpoint(this.Endpoint, this.ClientCredentials);
        }
        
        public PurchaseSharesClient(EndpointConfiguration endpointConfiguration, string remoteAddress) : 
                base(PurchaseSharesClient.GetBindingForEndpoint(endpointConfiguration), new System.ServiceModel.EndpointAddress(remoteAddress)) {
            this.Endpoint.Name = endpointConfiguration.ToString();
            ConfigureEndpoint(this.Endpoint, this.ClientCredentials);
        }
        
        public PurchaseSharesClient(EndpointConfiguration endpointConfiguration, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(PurchaseSharesClient.GetBindingForEndpoint(endpointConfiguration), remoteAddress) {
            this.Endpoint.Name = endpointConfiguration.ToString();
            ConfigureEndpoint(this.Endpoint, this.ClientCredentials);
        }
        
        public PurchaseSharesClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<VSClient.WebService.getFnameResponse> VSClient.WebService.PurchaseShares.getFnameAsync(VSClient.WebService.getFnameRequest request) {
            return base.Channel.getFnameAsync(request);
        }
        
        public System.Threading.Tasks.Task<VSClient.WebService.getFnameResponse> getFnameAsync(string username) {
            VSClient.WebService.getFnameRequest inValue = new VSClient.WebService.getFnameRequest();
            inValue.username = username;
            return ((VSClient.WebService.PurchaseShares)(this)).getFnameAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<VSClient.WebService.addStockResponse> VSClient.WebService.PurchaseShares.addStockAsync(VSClient.WebService.addStockRequest request) {
            return base.Channel.addStockAsync(request);
        }
        
        public System.Threading.Tasks.Task<VSClient.WebService.addStockResponse> addStockAsync(string name, string symbol, int volume, int value) {
            VSClient.WebService.addStockRequest inValue = new VSClient.WebService.addStockRequest();
            inValue.name = name;
            inValue.symbol = symbol;
            inValue.volume = volume;
            inValue.value = value;
            return ((VSClient.WebService.PurchaseShares)(this)).addStockAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<VSClient.WebService.userLoginResponse> VSClient.WebService.PurchaseShares.userLoginAsync(VSClient.WebService.userLoginRequest request) {
            return base.Channel.userLoginAsync(request);
        }
        
        public System.Threading.Tasks.Task<VSClient.WebService.userLoginResponse> userLoginAsync(string username, string password) {
            VSClient.WebService.userLoginRequest inValue = new VSClient.WebService.userLoginRequest();
            inValue.username = username;
            inValue.password = password;
            return ((VSClient.WebService.PurchaseShares)(this)).userLoginAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<VSClient.WebService.buySharesResponse> VSClient.WebService.PurchaseShares.buySharesAsync(VSClient.WebService.buySharesRequest request) {
            return base.Channel.buySharesAsync(request);
        }
        
        public System.Threading.Tasks.Task<VSClient.WebService.buySharesResponse> buySharesAsync(string companyName, int sharesWanted) {
            VSClient.WebService.buySharesRequest inValue = new VSClient.WebService.buySharesRequest();
            inValue.companyName = companyName;
            inValue.sharesWanted = sharesWanted;
            return ((VSClient.WebService.PurchaseShares)(this)).buySharesAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<VSClient.WebService.getSharesResponse> VSClient.WebService.PurchaseShares.getSharesAsync(VSClient.WebService.getSharesRequest request) {
            return base.Channel.getSharesAsync(request);
        }
        
        public System.Threading.Tasks.Task<VSClient.WebService.getSharesResponse> getSharesAsync(int arg0, string arg1, string arg2) {
            VSClient.WebService.getSharesRequest inValue = new VSClient.WebService.getSharesRequest();
            inValue.arg0 = arg0;
            inValue.arg1 = arg1;
            inValue.arg2 = arg2;
            return ((VSClient.WebService.PurchaseShares)(this)).getSharesAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<VSClient.WebService.getCurrencyNamesResponse> VSClient.WebService.PurchaseShares.getCurrencyNamesAsync(VSClient.WebService.getCurrencyNamesRequest request) {
            return base.Channel.getCurrencyNamesAsync(request);
        }
        
        public System.Threading.Tasks.Task<VSClient.WebService.getCurrencyNamesResponse> getCurrencyNamesAsync() {
            VSClient.WebService.getCurrencyNamesRequest inValue = new VSClient.WebService.getCurrencyNamesRequest();
            return ((VSClient.WebService.PurchaseShares)(this)).getCurrencyNamesAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<VSClient.WebService.addUserResponse> VSClient.WebService.PurchaseShares.addUserAsync(VSClient.WebService.addUserRequest request) {
            return base.Channel.addUserAsync(request);
        }
        
        public System.Threading.Tasks.Task<VSClient.WebService.addUserResponse> addUserAsync(string username, string password, string firstname) {
            VSClient.WebService.addUserRequest inValue = new VSClient.WebService.addUserRequest();
            inValue.username = username;
            inValue.password = password;
            inValue.firstname = firstname;
            return ((VSClient.WebService.PurchaseShares)(this)).addUserAsync(inValue);
        }
        
        public virtual System.Threading.Tasks.Task OpenAsync() {
            return System.Threading.Tasks.Task.Factory.FromAsync(((System.ServiceModel.ICommunicationObject)(this)).BeginOpen(null, null), new System.Action<System.IAsyncResult>(((System.ServiceModel.ICommunicationObject)(this)).EndOpen));
        }
        
        public virtual System.Threading.Tasks.Task CloseAsync() {
            return System.Threading.Tasks.Task.Factory.FromAsync(((System.ServiceModel.ICommunicationObject)(this)).BeginClose(null, null), new System.Action<System.IAsyncResult>(((System.ServiceModel.ICommunicationObject)(this)).EndClose));
        }
        
        private static System.ServiceModel.Channels.Binding GetBindingForEndpoint(EndpointConfiguration endpointConfiguration) {
            if ((endpointConfiguration == EndpointConfiguration.PurchaseSharesPort)) {
                System.ServiceModel.BasicHttpBinding result = new System.ServiceModel.BasicHttpBinding();
                result.MaxBufferSize = int.MaxValue;
                result.ReaderQuotas = System.Xml.XmlDictionaryReaderQuotas.Max;
                result.MaxReceivedMessageSize = int.MaxValue;
                result.AllowCookies = true;
                return result;
            }
            throw new System.InvalidOperationException(string.Format("Could not find endpoint with name \'{0}\'.", endpointConfiguration));
        }
        
        private static System.ServiceModel.EndpointAddress GetEndpointAddress(EndpointConfiguration endpointConfiguration) {
            if ((endpointConfiguration == EndpointConfiguration.PurchaseSharesPort)) {
                return new System.ServiceModel.EndpointAddress("http://localhost:8080/PurchaseShares/PurchaseShares");
            }
            throw new System.InvalidOperationException(string.Format("Could not find endpoint with name \'{0}\'.", endpointConfiguration));
        }
        
        private static System.ServiceModel.Channels.Binding GetDefaultBinding() {
            return PurchaseSharesClient.GetBindingForEndpoint(EndpointConfiguration.PurchaseSharesPort);
        }
        
        private static System.ServiceModel.EndpointAddress GetDefaultEndpointAddress() {
            return PurchaseSharesClient.GetEndpointAddress(EndpointConfiguration.PurchaseSharesPort);
        }
        
        public enum EndpointConfiguration {
            
            PurchaseSharesPort,
        }
    }
}
