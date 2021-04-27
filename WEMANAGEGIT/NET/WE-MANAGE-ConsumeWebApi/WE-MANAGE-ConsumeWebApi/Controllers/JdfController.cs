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
using Jdf = WE_MANAGE_ConsumeWebApi.Models.Jdf;
namespace WE_MANAGE_ConsumeWebApi.Controllers
{
    public class JdfController : Controller
    {
        // GET: Jdf
        public ActionResult Index()
        {



            HttpClient Client = new HttpClient();
            Client.BaseAddress = new Uri("http://localhost:8080");
            Client.DefaultRequestHeaders.Accept.Add(new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage response = Client.GetAsync("/getjdf").Result;
            IList<Jdf> jdfs;
            if (response.IsSuccessStatusCode)
            {
                jdfs = response.Content.ReadAsAsync<IList<Jdf>>().Result;
            }
            else
            {
                return View("Index");

            }

            return View(jdfs);
        }



        // GET: Delivery_Man/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Delivery_Man/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Create(Jdf jdf)
        {
            string Baseurl = "http://localhost:8080";

            using (var dm = new HttpClient())
            {
                dm.BaseAddress = new Uri(Baseurl);
                dm.DefaultRequestHeaders.Accept.Add(new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("application/json"));
                // client.DefaultRequestHeaders.Add("X-Miva-API-Authorization", "MIVA xxxxxxxxxxxxxxxxxxxxxx");
                var response = await dm.PostAsJsonAsync("add-jdf", jdf);
                if (response.IsSuccessStatusCode)
                {
                    return RedirectToAction("Index");
                }
            }
            return View(jdf);
        }






        public ActionResult Delete(long id)
        {



            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:8080");

            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage httpResponseMessage = client.GetAsync("/getJDF/" + id).Result;
            Jdf jdf;
            if (httpResponseMessage.IsSuccessStatusCode)
            {
                jdf = httpResponseMessage.Content.ReadAsAsync<Jdf>().Result;
            }
            else
            {
                jdf = null;
            }
            return View(jdf);
        }
        // POST: Delivery/Delete/5
        [HttpPost]
        public ActionResult Delete(long id, FormCollection collection)
        {
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080");

                //HTTP POST
                var putTask = client.DeleteAsync("/deleteJDF/" + id.ToString());
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
            Jdf jdf = null;
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080");
                //HTTP GET
                var responseTask = client.GetAsync("/getJDF/" + id);
                // responseTask.Wait();

                var result = responseTask.Result;
                if (result.IsSuccessStatusCode)
                {
                    var readTask = result.Content.ReadAsAsync<Jdf>();
                    readTask.Wait();

                    jdf = readTask.Result;
                }
            }
            return View(jdf);
        }

        // POST: Kid/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, string description, Jdf jdf)
        {
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080");

                //HTTP POST
                var putTask = client.PutAsJsonAsync<Jdf>("/mettreAjourDescriptionByJDFId/" + description + "/" + id, jdf);
                putTask.Wait();

                var result = putTask.Result;
                if (result.IsSuccessStatusCode)
                {

                    return RedirectToAction("Index");
                }
            }
            return View(jdf);
        }



        public ActionResult Details(int id)
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:8080");

            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage httpResponseMessage = client.GetAsync("/getJDF/" + id).Result;

            Jdf jdf;
            if (httpResponseMessage.IsSuccessStatusCode)
            {
                jdf = httpResponseMessage.Content.ReadAsAsync<Jdf>().Result;
            }
            else
            {
                jdf = null;
            }
            return View(jdf);
        }
    }
}