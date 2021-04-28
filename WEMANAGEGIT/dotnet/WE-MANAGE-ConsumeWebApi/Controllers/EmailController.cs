using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace WE_MANAGE_ConsumeWebApi.Controllers
{
    public class EmailController : Controller
    {
        // GET: Email
        public ActionResult EmailCompose()
        {
            return View();
        }
    }
}