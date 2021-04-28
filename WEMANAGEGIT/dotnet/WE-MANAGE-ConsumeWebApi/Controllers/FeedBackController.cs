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
using FeedBack = WE_MANAGE_ConsumeWebApi.Models.FeedBack;
using Jdf = WE_MANAGE_ConsumeWebApi.Models.Jdf;

namespace WE_MANAGE_ConsumeWebApi.Controllers
{
    public class FeedBackController : Controller
    {
        // GET: FeedBack
        public ActionResult Index()
        {



            HttpClient Client = new HttpClient();
            Client.BaseAddress = new Uri("http://localhost:8080");
            Client.DefaultRequestHeaders.Accept.Add(new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage response = Client.GetAsync("/getfeed").Result;
            IList<FeedBack> feedbacks;
            if (response.IsSuccessStatusCode)
            {
                feedbacks = response.Content.ReadAsAsync<IList<FeedBack>>().Result;
            }
            else
            {
                return View("Index");

            }

            return View(feedbacks);
        }

        [HttpGet]
        // GET: Notification/Create
        public ActionResult Create()
        {
            HttpClient Client = new HttpClient();
            Client.BaseAddress = new Uri("http://localhost:8080");
            Client.DefaultRequestHeaders.Accept.Add(new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage response = Client.GetAsync("/getjdf").Result;
            IEnumerable<Jdf> jdfs;

            if (response.IsSuccessStatusCode)
            {
                jdfs = response.Content.ReadAsAsync<IEnumerable<Jdf>>().Result;
            }
            else
            {
                jdfs = null;
            }
            ViewBag.jdf_id = new SelectList(jdfs, "id", "Id");

            return View();
        }

        // POST: Consultation/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Create(FeedBack feed)
        {

            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:8080/");
            client.DefaultRequestHeaders.Accept.Add(new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("application/json"));

            var response = await client.PostAsJsonAsync("add-Feed/" + feed.jdf_id, feed);
            if (response.IsSuccessStatusCode)
            {
                return RedirectToAction("Index");
            }

            HttpResponseMessage httpResponseMessage = client.GetAsync("/getjdf").Result;
            IEnumerable<Jdf> jdfs;
            if (httpResponseMessage.IsSuccessStatusCode)
            {
                jdfs = httpResponseMessage.Content.ReadAsAsync<IEnumerable<Jdf>>().Result;
            }
            else
            {
                jdfs = null;
            }

            ViewBag.jdf_id = new SelectList(jdfs, "jdf");

            return View(feed);
        }
        public ActionResult Details(int id)
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:8080");

            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage httpResponseMessage = client.GetAsync("/getFeed/" + id).Result;

            FeedBack fed;
            if (httpResponseMessage.IsSuccessStatusCode)
            {
                fed = httpResponseMessage.Content.ReadAsAsync<FeedBack>().Result;
            }
            else
            {
                fed = null;
            }
            return View(fed);
        }
        public ActionResult Edit(int id)
        {
            FeedBack fed = null;
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080");
                //HTTP GET
                var responseTask = client.GetAsync("/getFeed/" + id);
                // responseTask.Wait();

                var result = responseTask.Result;
                if (result.IsSuccessStatusCode)
                {
                    var readTask = result.Content.ReadAsAsync<FeedBack>();
                    readTask.Wait();

                    fed = readTask.Result;
                }
            }
            return View(fed);
        }
        [HttpPost]
        public ActionResult Edit(int id, float note, FeedBack fed)
        {
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080");

                //HTTP POST
                var putTask = client.PutAsJsonAsync<FeedBack>("/mettreAjourNoteByFeedId/" + note + "/" + id, fed);
                putTask.Wait();

                var result = putTask.Result;
                if (result.IsSuccessStatusCode)
                {

                    return RedirectToAction("Index");
                }
            }
            return View(fed);
        }
        public ActionResult Delete(long id)
        {



            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:8080");

            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage httpResponseMessage = client.GetAsync("/getFeed/" + id).Result;
            FeedBack fed;
            if (httpResponseMessage.IsSuccessStatusCode)
            {
                fed = httpResponseMessage.Content.ReadAsAsync<FeedBack>().Result;
            }
            else
            {
                fed = null;
            }
            return View(fed);
        }
        // POST: Delivery/Delete/5
        [HttpPost]
        public ActionResult Delete(long id, FormCollection collection)
        {
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080");

                //HTTP POST
                var putTask = client.DeleteAsync("/deleteFeed/" + id.ToString());
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