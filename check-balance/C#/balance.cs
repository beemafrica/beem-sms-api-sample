using System;
using Gtk;
using System.IO;
using System.Net;
using System.Text;
using System.Windows.Forms;


public partial class MainWindow : Gtk.Window
{
    public MainWindow() : base(Gtk.WindowType.Toplevel)
    {
        Build();
    }

    protected void OnDeleteEvent(object sender, DeleteEventArgs a)
    {
        Gtk.Application.Quit();
        a.RetVal = true;
    }

    protected void OnButton1Clicked(object sender, EventArgs e)
    {

        //throw new NotImplementedException ();
        string result = null;
        //throw new NotImplementedException ();
        string username = "Enter your username";
        string password = "Enter your password";
        string request = "balance";
    

        String url = "http://www.bongolive.co.tz/api/request.php?username=" + username + "&password=" + password + "&request=" + request;


        StreamWriter myWriter = null;
        HttpWebRequest objRequest = (HttpWebRequest)WebRequest.Create(url);
        objRequest.Method = "POST";
        objRequest.ContentLength = Encoding.UTF8.GetByteCount(url);
        objRequest.ContentType = "application/x-www-form-urlencoded";
        try
        {
            myWriter = new StreamWriter(objRequest.GetRequestStream());
            myWriter.Write(url);

        }
        catch (Exception ex)
        {
            //return e.Message;
            MessageBox.Show(null, "the error is" + ex, MessageBoxButtons.OK, MessageBoxIcon.Information);
        }
        finally
        {
            myWriter.Close();
        }

        HttpWebResponse objResponse = (HttpWebResponse)objRequest.GetResponse();
        using (StreamReader sr = new StreamReader(objResponse.GetResponseStream()))
        {
            result = sr.ReadToEnd();
            // Close and clean up the StreamReader
            sr.Close();
        }
        //return result;
        MessageBox.Show(result);


        Console.Write("hello");

    }
}