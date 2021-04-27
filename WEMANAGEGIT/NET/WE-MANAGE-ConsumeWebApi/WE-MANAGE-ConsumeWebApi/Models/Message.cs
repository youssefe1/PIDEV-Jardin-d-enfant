using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WE_MANAGE_ConsumeWebApi.Models
{
    public class Message
    {
		public long Id { get; set; }
		public MessageType type { get; set; }

		public string body { get; set; }
		public long user_id { get; set; }

		public DateTime date { get; set; }
		

		public User sender;
		public enum MessageType
		{
			CHAT,
			JOIN,
			LEAVE
		}



	}
}