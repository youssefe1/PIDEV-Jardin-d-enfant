using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;
using WE_MANAGE_ConsumeWebApi.Enumerations;

namespace WE_MANAGE_ConsumeWebApi.Models
{
    public class Bus
    {
      
            [Key]
            public long matricule { get; set; }

            public string driver { get; set; }
            public int seatCapacity { get; set; }
            public string latStart { get; set; }
            public string lonStart { get; set; }

            public string latArrival { get; set; }
            public string lonArrival { get; set; }

            public string rate { get; set; }


            public double Trajet { get; set; }
       
        public Jdf kindergarten { get; set; }
        
    }
}