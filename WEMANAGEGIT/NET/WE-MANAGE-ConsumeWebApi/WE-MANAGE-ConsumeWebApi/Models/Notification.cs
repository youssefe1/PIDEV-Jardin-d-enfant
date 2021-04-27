using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace WE_MANAGE_ConsumeWebApi.Models
{
    public class Notification
    {
		public long Id { get; set; }

		public string body { get; set; }
		public DateTime createdAt { get; set; }
		public string link { get; set; }
		public string notifType { get; set; }
		public bool seen { get; set; }
		public long user_id { get; set; }

		public User user; 
		
	}
}