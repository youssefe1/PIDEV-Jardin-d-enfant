using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Drawing.Imaging;
using System.IO;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text;
using System.Threading.Tasks;
using System.Web;
using System.Web.Mvc;
using WE_MANAGE_ConsumeWebApi.Models;

namespace WE_MANAGE_ConsumeWebApi.Controllers
{
    public class EventController : Controller
    {
        // GET: Event
     
        public ActionResult Index()
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:8080");

            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage httpResponseMessage = client.GetAsync("/getEvents").Result;

            IEnumerable<Event> events;
            if (httpResponseMessage.IsSuccessStatusCode)
            {
                events = httpResponseMessage.Content.ReadAsAsync<IEnumerable<Event>>().Result;


            }
            else
            {
                events = null;
            }
            return View(events);
        }



        // GET: event/ViewMore/1
        public ActionResult ViewMore(int id)
        {
            Event e = null;
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080");
                //HTTP GET
                var responseTask = client.GetAsync("getEventById/" + id);
                // responseTask.Wait();

                var result = responseTask.Result;
                if (result.IsSuccessStatusCode)
                {
                    var readTask = result.Content.ReadAsAsync<Event>();
                    readTask.Wait();

                    e = readTask.Result;
                }
            }
            return View(e);
        }


        // GET: EventByDate
        public ActionResult Sorted(string searchString)
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:8080");

            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage httpResponseMessage = client.GetAsync("/EventSotedByDate").Result;

            IEnumerable<Event> events;

            if (httpResponseMessage.IsSuccessStatusCode)
            {
                events = httpResponseMessage.Content.ReadAsAsync<IEnumerable<Event>>().Result;


            }
            else
            {
                events = null;
            }
            return View(events);
        }


        public ActionResult Create()
        {
            return View();
        }

        // POST: /Event/Create
        [HttpPost]
        [AllowAnonymous]

        public async Task<ActionResult> Create(Event m, HttpPostedFileBase file)
        {


            if (ModelState.IsValid)
            {

                m.photo = file.FileName;

                var customerJson = await Task.Run(() => JsonConvert.SerializeObject(m));

                HttpClient client = new HttpClient();
                client.BaseAddress = new Uri("http://localhost:8080/");
                var content = new StringContent(customerJson.ToString(), Encoding.UTF8, "application/json");
                HttpResponseMessage response;
                System.Diagnostics.Debug.WriteLine(file.FileName);
                var path = Path.Combine(Server.MapPath("~/EventImages/"), file.FileName);
                Image image = Image.FromStream(file.InputStream, true, true);
                image.Save(path, ImageFormat.Png);

                response = client.PostAsync("addEvent/", content).Result;
                return RedirectToAction("DisplayClientEvents");

            }
            return View(m);

            // If we got this far, something failed, redisplay form

        }





        // GET: event/Edit/1
        public ActionResult Edit(int id)
        {
            Event e = null;
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080");
                //HTTP GET
                var responseTask = client.GetAsync("getEventById/" + id);
                // responseTask.Wait();

                var result = responseTask.Result;
                if (result.IsSuccessStatusCode)
                {
                    var readTask = result.Content.ReadAsAsync<Event>();
                    readTask.Wait();

                    e = readTask.Result;
                }
            }
            return View(e);
        }

        // POST: event/Edit/1
        [HttpPost]
        public ActionResult Edit(int id, Event e)
        {
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:8080");

                //HTTP POST
                var putTask = client.PutAsJsonAsync<Event>("/updateevent/" + id, e);
                putTask.Wait();

                var result = putTask.Result;
                if (result.IsSuccessStatusCode)
                {

                    return RedirectToAction("DisplayClientEvents");
                }
            }
            return View(e);
        }






        // GET: ClientEvents
        public ActionResult DisplayClientEvents()
        {

            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:8080");

            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage httpResponseMessage = client.GetAsync("/EventSotedByDate").Result;

            IEnumerable<Event> events;
            if (httpResponseMessage.IsSuccessStatusCode)
            {
                events = httpResponseMessage.Content.ReadAsAsync<IEnumerable<Event>>().Result;


            }
            else
            {
                events = null;
            }
            return View(events);

        }






        public async Task<ActionResult> RejectEvent(long idevent, long iduser, string etat)
        {
            try
            {
                Event eventi = new Event();
                User user = new User();
                eventi.id = idevent;
                user.id = iduser;
                var eventJson = await Task.Run(() => JsonConvert.SerializeObject(eventi));
                HttpClient client = new HttpClient();
                client.BaseAddress = new Uri("http://localhost:8080/");
                var content = new StringContent(eventJson.ToString(), Encoding.UTF8, "application/json");
                HttpResponseMessage response = client.PutAsync("/annuler_participer_event/" + idevent + iduser + etat, content).Result;
                return RedirectToAction("DisplayEvents");
            }
            catch
            {
                return View(idevent);
            }

        }


        // GET: Event/Delete/5
        public ActionResult Delete(int id)
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:8080");

            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage httpResponseMessage = client.GetAsync("getEventById/" + id).Result;

            Event e;
            if (httpResponseMessage.IsSuccessStatusCode)
            {
                e = httpResponseMessage.Content.ReadAsAsync<Event>().Result;
            }
            else
            {
                e = null;
            }
            return View(e);
        }

        // POST: Event/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:8080");

            //client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            var putTask = client.DeleteAsync("/deleteevent/" + id);
            putTask.Wait();
            var result = putTask.Result;
            if (result.IsSuccessStatusCode)
            {

                return RedirectToAction("DisplayClientEvents");
            }
            return View();
        }
    }
}