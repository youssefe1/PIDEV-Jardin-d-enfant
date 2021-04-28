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
    public class UserController : Controller
    {
        // GET: User
        public ActionResult Index()
        {



            HttpClient Client = new HttpClient();
            Client.BaseAddress = new Uri("http://localhost:8080");
            Client.DefaultRequestHeaders.Accept.Add(new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage response = Client.GetAsync("/users").Result;
            IList<User> users;
            if (response.IsSuccessStatusCode)
            {
                users = response.Content.ReadAsAsync<IList<User>>().Result;
            }
            else
            {
                return View("Index");

            }

            return View(users);
        }
        public ActionResult Create()
        {
            return View();
        }

        // POST: Delivery_Man/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Create(User usr)
        {
            string Baseurl = "http://localhost:8080";

            using (var dm = new HttpClient())
            {
                dm.BaseAddress = new Uri(Baseurl);
                dm.DefaultRequestHeaders.Accept.Add(new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("application/json"));
                // client.DefaultRequestHeaders.Add("X-Miva-API-Authorization", "MIVA xxxxxxxxxxxxxxxxxxxxxx");
                var response = await dm.PostAsJsonAsync("/user/add", usr);
                if (response.IsSuccessStatusCode)
                {
                    return RedirectToAction("Index");
                }
            }
            return View(usr);
        }
        public ActionResult Edit(int id)
        {
            User usr = null;
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080");
                //HTTP GET
                var responseTask = client.GetAsync("/user/" + id);
                // responseTask.Wait();

                var result = responseTask.Result;
                if (result.IsSuccessStatusCode)
                {
                    var readTask = result.Content.ReadAsAsync<User>();
                    readTask.Wait();

                    usr = readTask.Result;
                }
            }
            return View(usr);
        }
        [HttpPost]
        public ActionResult Edit(int id, User usr)
        {
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080");

                //HTTP POST
                var putTask = client.PutAsJsonAsync<User>("/user/" + id + "/edit", usr);
                putTask.Wait();

                var result = putTask.Result;
                if (result.IsSuccessStatusCode)
                {

                    return RedirectToAction("Index");
                }
            }
            return View(usr);
        }


        public ActionResult Details(int id)
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:8080");

            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage httpResponseMessage = client.GetAsync("/user/" + id).Result;

            User usr;
            if (httpResponseMessage.IsSuccessStatusCode)
            {
                usr = httpResponseMessage.Content.ReadAsAsync<User>().Result;
            }
            else
            {
                usr = null;
            }
            return View(usr);
        }

        public ActionResult Delete(long id)
        {



            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:8080");

            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage httpResponseMessage = client.GetAsync("/user/" + id).Result;
            User usr;
            if (httpResponseMessage.IsSuccessStatusCode)
            {
                usr = httpResponseMessage.Content.ReadAsAsync<User>().Result;
            }
            else
            {
                usr = null;
            }
            return View(usr);
        }
        [HttpPost]
        public ActionResult Delete(long id, FormCollection collection)
        {
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080");

                //HTTP POST
                var putTask = client.DeleteAsync("/user/" + id.ToString() + "/delete");
                putTask.Wait();

                var result = putTask.Result;
                if (result.IsSuccessStatusCode)
                {

                    return RedirectToAction("Index");
                }
            }
            return View(id);
        }
    } 
}