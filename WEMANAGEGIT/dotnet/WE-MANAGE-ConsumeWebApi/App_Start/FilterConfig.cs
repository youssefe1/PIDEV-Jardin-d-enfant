﻿using System.Web;
using System.Web.Mvc;

namespace WE_MANAGE_ConsumeWebApi
{
    public class FilterConfig
    {
        public static void RegisterGlobalFilters(GlobalFilterCollection filters)
        {
            filters.Add(new HandleErrorAttribute());
        }
    }
}
