using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WE_MANAGE_ConsumeWebApi.Models
{
    public class User
    {
        public long id { get; set; }
        
    public string userName { get; set; }

        public string password { get; set; }

        public string roles { get; set; }
        public bool active { get; set; }

        public string etat { get; set; }

        public string email { get; set; }
        public int telephone { get; set; }
        public string adresse { get; set; }
        public string firstName { get; set; }
        public string lastName { get; set; }
       public virtual ICollection<Notification> notifications { get; set; }
        public IEnumerable<User> Users { get; set; }



    }
}