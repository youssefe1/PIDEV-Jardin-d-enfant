using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WE_MANAGE_ConsumeWebApi.Models
{
    public class EventParticipantsInvitation
    {

        public Pk Id { get; set; }
        public string answer { get; set; }
        public DateTime invitation_date { get; set; }
        public DateTime answer_date { get; set; }



        //-----------------------------
        //Relationships

        // public virtual Bus Bus { get; set; }
        // public virtual User User { get; set; }
    }
}