using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WeManage.Models
{
    public class LikePost
    {
        public long id { get; set; }
        public bool isLike { get; set; }
        public bool disLike { get; set; }
        public long postId { get; set; }
        public long userId { get; set; }
        public DateTime createdAt { get; set; }
        public DateTime updatedAt { get; set; }
    }
}