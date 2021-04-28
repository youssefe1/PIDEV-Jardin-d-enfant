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
using Message = WE_MANAGE_ConsumeWebApi.Models.Message;
using User = WE_MANAGE_ConsumeWebApi.Models.User;

namespace WE_MANAGE_ConsumeWebApi.Controllers
{
    public class MessageController : Controller
    {
        // GET: Message
        public ActionResult Index()
        {



            HttpClient Client = new HttpClient();
            Client.BaseAddress = new Uri("http://localhost:8080");
            Client.DefaultRequestHeaders.Accept.Add(new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage response = Client.GetAsync("/getmessages").Result;
            IList<Message> messages;
            if (response.IsSuccessStatusCode)
            {
                messages = response.Content.ReadAsAsync<IList<Message>>().Result;
            }
            else
            {
                return View("Index");

            }

            return View(messages);
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
            ViewBag.user_id = new SelectList(users, "id", "Id");

            return View();
        }

        // POST: Consultation/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Create(Message mes)
        {

            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:8080/");
            client.DefaultRequestHeaders.Accept.Add(new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("application/json"));

            var response = await client.PostAsJsonAsync("add-mes/" + mes.user_id, mes);
            if (response.IsSuccessStatusCode)
            {
                return Redirect("/Message/Index");
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

            return View(mes);
        }

        public ActionResult Delete(long id)
        {



            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:8080");

            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage httpResponseMessage = client.GetAsync("/getMes/" + id).Result;
            Message not;
            if (httpResponseMessage.IsSuccessStatusCode)
            {
                not = httpResponseMessage.Content.ReadAsAsync<Message>().Result;
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
                var putTask = client.DeleteAsync("/deleteMessage/" + id.ToString());
                putTask.Wait();

                var result = putTask.Result;
                if (result.IsSuccessStatusCode)
                {

                    return Redirect("/Message/Index");
                }
            }
            return View(id);
        }
        // GET: Kid/Edit/5
        public ActionResult Edit(int id)
        {
            Message not = null;
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080");
                //HTTP GET
                var responseTask = client.GetAsync("/getMes/" + id);
                // responseTask.Wait();

                var result = responseTask.Result;
                if (result.IsSuccessStatusCode)
                {
                    var readTask = result.Content.ReadAsAsync<Message>();
                    readTask.Wait();

                    not = readTask.Result;
                }
            }
            return View(not);
        }

        // POST: Kid/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, string body, Message not)
        {
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080");

                //HTTP POST
                var putTask = client.PutAsJsonAsync<Message>("/mettreAjourBodyByMessageId/" + body + "/" + id, not);
                putTask.Wait();

                var result = putTask.Result;
                if (result.IsSuccessStatusCode)
                {

                    return Redirect("/Message/Index");
                }
            }
            return View(not);
        }



        public ActionResult Details(int id)
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:8080");

            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage httpResponseMessage = client.GetAsync("/getMes/" + id).Result;

            Message not;
            if (httpResponseMessage.IsSuccessStatusCode)
            {
                not = httpResponseMessage.Content.ReadAsAsync<Message>().Result;
            }
            else
            {
                not = null;
            }
            return View(not);
        }
        public ActionResult Index2()
        {
            return View("Index2");

        }
    }

}