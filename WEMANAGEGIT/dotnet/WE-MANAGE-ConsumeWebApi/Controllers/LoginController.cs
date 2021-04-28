using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace WE_MANAGE_ConsumeWebApi.Controllers
{
    public class LoginController : Controller
    {
        
        public ActionResult signIn()
        {
            return View("signIn");
        }
        
        public ActionResult signUp()
        {
            return View("signUp");
        }
        public ActionResult confirm_mail()
        {
            return View("signUp");
        }
    }
}