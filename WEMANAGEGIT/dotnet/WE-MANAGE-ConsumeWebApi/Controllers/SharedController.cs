using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Net.Http;
using WE_MANAGE_ConsumeWebApi.Models;
using System.Net.Http.Formatting;
using Microsoft.Azure.ActiveDirectory.GraphClient;
using System.Threading.Tasks;
using System.Net.Http.Headers;
using User = WE_MANAGE_ConsumeWebApi.Models.User;

namespace WE_MANAGE_ConsumeWebApi.Controllers
{
    public class SharedController : Controller
    {
        // GET: Shared
        public ActionResult Index()
        {

            HttpClient Client = new HttpClient();
            Client.BaseAddress = new Uri("http://localhost:8080");
            Client.DefaultRequestHeaders.Accept.Add(new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage response = Client.GetAsync("/getnotifications").Result;
            IList<Notification> notifications;
            if (response.IsSuccessStatusCode)
            {
                notifications = response.Content.ReadAsAsync<IList<Notification>>().Result;
            }
            else
            {
                return View("_Layout");

            }

            return View(notifications);
        }
    }
}