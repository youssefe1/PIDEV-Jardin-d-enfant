using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WE_MANAGE_ConsumeWebApi.Models
{
    public class Jdf
    {
		public long id { get; set; }
		public float fee { get; set; }

		public int review { get; set; }
		public string description { get; set; }
		public string logo { get; set; }
		public DateTime date_Creation { get; set; }
		public int nbr_Emp { get; set; }
		public string email { get; set; }
		public string localisation { get; set;  }



	}
}