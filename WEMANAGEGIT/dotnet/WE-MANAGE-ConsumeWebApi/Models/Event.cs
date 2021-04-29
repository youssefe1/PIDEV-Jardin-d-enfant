
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;
using WE_MANAGE_ConsumeWebApi.Enumerations;

namespace WE_MANAGE_ConsumeWebApi.Models
{
    public class Event
    {
        [Key]
        public long id { get; set; }
        public string title { get; set; }
        public string description { get; set; }

        public string photo { get; set; }
        public int fee_supp { get; set; }
        public EventType type { get; set; }
        public EventEtat etat { get; set; }
        public EventCategory category { get; set; }
        public int nbrParticipants { get; set; }
        public int nbrInvites { get; set; }
        [DisplayFormat(DataFormatString = "{0:yyyy-MM-dd}", ApplyFormatInEditMode = true)]
        [DataType(DataType.Date)]
        [Required]
        public DateTime? eventDate { get; set; }

        [DisplayFormat(DataFormatString = "{0:HH:mm:ss}", ApplyFormatInEditMode = true)]
        [DataType(DataType.Date)]
        [Required]
        public DateTime? eventStartDate { get; set; }
        [DisplayFormat(DataFormatString = "{0:HH:mm:ss}", ApplyFormatInEditMode = true)]
        [DataType(DataType.Date)]
        [Required]
        public DateTime? eventEndDate { get; set; }



        public Jdf kindergartenevent { get; set; }

    }
}