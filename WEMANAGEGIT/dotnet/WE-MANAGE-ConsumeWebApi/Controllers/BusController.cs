using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;
using System.Web;
using System.Web.Mvc;
using WE_MANAGE_ConsumeWebApi.Models;

namespace WE_MANAGE_ConsumeWebApi.Controllers
{
    public class BusController : Controller
    {
        public ActionResult Buses()
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:8080");

            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage httpResponseMessage = client.GetAsync("/getAllBus").Result;

            IEnumerable<Bus> buses;
            if (httpResponseMessage.IsSuccessStatusCode)
            {
                buses = httpResponseMessage.Content.ReadAsAsync<IEnumerable<Bus>>().Result;


            }
            else
            {
                buses = null;
            }
            return View(buses);
        }

        // GET: bus/Details
        public ActionResult Details(int id)
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:8080");

            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage httpResponseMessage = client.GetAsync("/{matricule}" + id).Result;

            Bus bus;
            if (httpResponseMessage.IsSuccessStatusCode)
            {
                bus = httpResponseMessage.Content.ReadAsAsync<Bus>().Result;
            }
            else
            {
                bus = null;
            }
            return View(bus);
        }
        // GET: bus/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: bus/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Create(Bus bus)
        {

            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:8080");
            client.DefaultRequestHeaders.Accept.Add(new System.Net.Http.Headers.MediaTypeWithQualityHeaderValue("application/json"));

            var response = await client.PostAsJsonAsync("/addBus", bus);
            if (response.IsSuccessStatusCode)
            {
                return RedirectToAction("Buses");
            }

            return View(bus);
        }

        // GET: Kid/Edit/1
        public ActionResult Edit(int id)
        {
            Bus bus = null;
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080");
                //HTTP GET
                var responseTask = client.GetAsync("get/" + id);
                // responseTask.Wait();

                var result = responseTask.Result;
                if (result.IsSuccessStatusCode)
                {
                    var readTask = result.Content.ReadAsAsync<Bus>();
                    readTask.Wait();

                    bus = readTask.Result;
                }
            }
            return View(bus);
        }

        // POST: Kid/Edit/1
        [HttpPost]
        public ActionResult Edit(int id, Bus bus)
        {
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080");

                //HTTP POST
                var putTask = client.PutAsJsonAsync<Bus>("/updatebus/" + id, bus);
                putTask.Wait();

                var result = putTask.Result;
                if (result.IsSuccessStatusCode)
                {

                    return RedirectToAction("Buses");
                }
            }
            return View(bus);
        }




        // GET: bus/Delete/1
        public ActionResult Delete(int id)
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:8080");

            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage httpResponseMessage = client.GetAsync("get/" + id).Result;

            Bus bus;
            if (httpResponseMessage.IsSuccessStatusCode)
            {
                bus = httpResponseMessage.Content.ReadAsAsync<Bus>().Result;
            }
            else
            {
                bus = null;
            }
            return View(bus);
        }

        // POST: bus/Delete/
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:8080");

            //client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            var putTask = client.DeleteAsync("/deleteBus/" + id);
            putTask.Wait();
            var result = putTask.Result;
            if (result.IsSuccessStatusCode)
            {

                return RedirectToAction("Buses");
            }
            return View();
        }

    }

}
