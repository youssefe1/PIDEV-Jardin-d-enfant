using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WE_MANAGE_ConsumeWebApi.Models
{
    public class FeedBack
    {
		public long Id { get; set; }
		public float note { get; set; }

		public string q1 { get; set; }
		public string q2 { get; set; }
		public string q3 { get; set; }
		public string q4 { get; set; }
		public string q5 { get; set; }
		public long jdf_id { get; set; }



		public Jdf jdf;
	}
}