using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Web;

namespace WeManage.Models
{
    public class Post
    {
        public long id { get; set; }
        public string textContent { get; set; }
        public string urlMedia { get; set; }
        public Collection<Comment> comments { get; set; }
        public Collection<LikePost> LikePosts { get; set; }
        public User user { get; set; }
        public long userId { get; set; }
        public DateTime createdAt { get; set; }
        public DateTime updatedAt { get; set; }
    }
}
