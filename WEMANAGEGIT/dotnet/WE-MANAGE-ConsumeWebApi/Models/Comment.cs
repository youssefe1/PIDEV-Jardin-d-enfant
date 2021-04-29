using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Web;

namespace WeManage.Models
{
    public class Comment
    {
        public long id { get; set; }
        public string content { get; set; }
        public long postId { get; set; }
        public User user { get; set; }
        public long userId { get; set; }
        public Collection<LikeComment> LikeComments { get; set; }
        public DateTime createdAt { get; set; }
        public DateTime updatedAt { get; set; }
    }
}
