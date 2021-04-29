using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Web;
using System.Web.Mvc;
using WeManage.Models;

namespace WeManage.Controllers
{
    public class CommentController : Controller
    {
        HttpClient httpClient;
        string baseAddress;

        public CommentController()
        {
            baseAddress = "http://localhost:3036/";
            httpClient = new HttpClient();
            httpClient.BaseAddress = new Uri(baseAddress);
            httpClient.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        }

        public ActionResult Index(int? id)
        {
            return RedirectToAction("Index", "Post");

        }

        // GET: Comment/Details/5
        public ActionResult Details(int? id)
        {
            if (id.ToString() != "")
            {
                Comment comment = null;
                var response = httpClient.GetAsync("comment/" + id.ToString());
                response.Wait();

                var result = response.Result;
                if (result.IsSuccessStatusCode)
                {
                    var read = result.Content.ReadAsAsync<Comment>();
                    read.Wait();

                    comment = read.Result;

                    return View(comment);
                }
            }

            // id is empty or no comment was found with the given id
            return RedirectToAction("Index", "Post");
        }

        // GET: Comment/Create
        public ActionResult Create(int? id, int? userId)
        {
            if (id.ToString() != "")
            {
                ViewBag.postId = id;
                ViewBag.userId = userId;
            }

            return View();
        }

        // POST: Comment/Create
        [HttpPost]
        public ActionResult Create(Comment comment)
        {
            comment.user = null;
            var task = httpClient.PostAsJsonAsync<Comment>("comment", comment);
            task.Wait();

            var result = task.Result;
            if (result.IsSuccessStatusCode)
            {
                return RedirectToAction("Details", "Post", new { id = comment.postId });
            }

            ModelState.AddModelError(string.Empty, "Error: Cannot create the comment, please try again.");
            return View(comment);
        }

        // GET: Comment/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id.ToString() != "")
            {
                Comment comment = null;
                var response = httpClient.GetAsync("comment/" + id.ToString());
                response.Wait();

                var result = response.Result;
                if (result.IsSuccessStatusCode)
                {
                    var read = result.Content.ReadAsAsync<Comment>();
                    read.Wait();

                    comment = read.Result;

                    return View(comment);
                }
            }

            // id is empty or no comment was found with the given id
            return RedirectToAction("Index", "Post");
        }

        // PUT: Comment/Edit/5
        [HttpPost]
        public ActionResult Edit(Comment comment, int? id)
        {
            if (id.ToString() != "")
            {
                var task = httpClient.PutAsJsonAsync<Comment>("comment/" + id.ToString(), comment);
                task.Wait();

                var result = task.Result;
                if (result.IsSuccessStatusCode)
                {
                    return RedirectToAction("Details", "Post", new { id = comment.postId });
                }
            }

            // id is empty or an error occured when editing the comment
            ModelState.AddModelError(string.Empty, "Error: Cannot edit the comment, please try again.");
            return View(comment);
        }

        // GET: Comment/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id.ToString() != "")
            {
                Comment comment = null;
                var response = httpClient.GetAsync("comment/" + id.ToString());
                response.Wait();

                var result = response.Result;
                if (result.IsSuccessStatusCode)
                {
                    var read = result.Content.ReadAsAsync<Comment>();
                    read.Wait();

                    comment = read.Result;

                    return View(comment);
                }
            }

            // id is empty or no comment was found with the given id
            return RedirectToAction("Index", "Post");
        }

        // POST: Comment/Delete/5
        [HttpPost]
        public ActionResult Delete(Comment comment, int? id)
        {
            if (id.ToString() != "")
            {
                var task = httpClient.DeleteAsync("comment/" + id.ToString());
                task.Wait();

                var result = task.Result;
                if (result.IsSuccessStatusCode)
                {
                    return RedirectToAction("Details", "Post", new { id = comment.postId });
                }
            }

            // id is empty or an error occured when deleting the comment
            ModelState.AddModelError(string.Empty, "Error: Cannot delete the comment, please try again.");
            return View(comment);
        }
    }
}
