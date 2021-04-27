using OfficeDevPnP.Core.WebAPI;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Web;
using System.Web.Mvc;
using WE_MANAGE_ConsumeWebApi.Models;
using System.Net.Http.Formatting;
using Microsoft.Azure.ActiveDirectory.GraphClient;
using System.Threading.Tasks;
using System.Net.Http.Headers;
using User = WE_MANAGE_ConsumeWebApi.Models.User;

namespace WE_MANAGE_ConsumeWebApi.Controllers
{
    public class NotificationController : Controller
    {

        // GET: Notification
    
        public ActionResult Index()
        {
            //var list = WebAPIHelper.Get<IList<Notification>>("notifications");
            
        

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
                return View("Index");

            }

            return View(notifications);
        }



        [HttpGet]
        // GET: Notification/Create
        public ActionResult Create()
        {
            HttpClient Client = new HttpClient();
            Client.BaseAddress = new Uri("http://localhost:8080");
            Client.DefaultRequestHeaders.Accept.Add(new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage response = Client.GetAsync("/users").Result;
            IEnumerable<User> users;

            if (response.IsSuccessStatusCode)
            {
                users = response.Content.ReadAsAsync<IEnumerable<User>>().Result;
            }
            else
            {
                users = null;
            }
            ViewBag.user_id = new SelectList(users, "id","Id");

            return View();
        }

        // POST: Consultation/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Create(Notification not)
        {

            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:8080/");
            client.DefaultRequestHeaders.Accept.Add(new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("application/json"));

            var response = await client.PostAsJsonAsync("add-notification/"+not.user_id, not);
             if (response.IsSuccessStatusCode)
             {
                 return RedirectToAction("Index");
             }
           
            HttpResponseMessage httpResponseMessage = client.GetAsync("users").Result;
            IEnumerable<User> users;
            if (httpResponseMessage.IsSuccessStatusCode)
            {
                users = httpResponseMessage.Content.ReadAsAsync<IEnumerable<User>>().Result;
            }
            else
            {
                users = null;
            }

            ViewBag.user_id = new SelectList(users, "user");

            return View(not);
        }







        public ActionResult Delete(long id)
        {



            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:8080");

            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage httpResponseMessage = client.GetAsync("/getNotif/" + id).Result;
            Notification not;
            if (httpResponseMessage.IsSuccessStatusCode)
            {
                not = httpResponseMessage.Content.ReadAsAsync<Notification>().Result;
            }
            else
            {
                not = null;
            }
            return View(not);
        }

        // POST: Delivery/Delete/5
        [HttpPost]
        public ActionResult Delete(long id, FormCollection collection)
        {
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080");

                //HTTP POST
                var putTask = client.DeleteAsync("/deleteNotifById/" + id.ToString());
                putTask.Wait();

                var result = putTask.Result;
                if (result.IsSuccessStatusCode)
                {

                    return RedirectToAction("Index");
                }
            }
            return View(id);
        }
        // GET: Kid/Edit/5
        public ActionResult Edit(int id)
        {
            Notification not = null;
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080");
                //HTTP GET
                var responseTask = client.GetAsync("/getNotif/" + id);
                // responseTask.Wait();

                var result = responseTask.Result;
                if (result.IsSuccessStatusCode)
                {
                    var readTask = result.Content.ReadAsAsync<Notification>();
                    readTask.Wait();

                    not = readTask.Result;
                }
            }
            return View(not);
        }

        // POST: Kid/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, string body, Notification not)
        {
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080");

                //HTTP POST
                var putTask = client.PutAsJsonAsync<Notification>("/mettreAjourBodyByNotifId/" + body + "/" +id, not);
                putTask.Wait();

                var result = putTask.Result;
                if (result.IsSuccessStatusCode)
                {

                    return RedirectToAction("Index");
                }
            }
            return View(not);
        }



        public ActionResult Details(int id)
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:8080");

            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage httpResponseMessage = client.GetAsync("/getNotif/" + id).Result;

            Notification not;
            if (httpResponseMessage.IsSuccessStatusCode)
            {
                not = httpResponseMessage.Content.ReadAsAsync<Notification>().Result;
            }
            else
            {
                not = null;
            }
            return View(not);
        }

    }
}