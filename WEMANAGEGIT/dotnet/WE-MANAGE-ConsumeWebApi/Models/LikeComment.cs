using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WeManage.Models
{
    public class LikeComment
    {
        public long id { get; set; }
        public long commentId { get; set; }
        public long userId { get; set; }
        public bool isLike { get; set; }
        public bool disLike { get; set; }
        public DateTime createdAt { get; set; }
        public DateTime updatedAt { get; set; }
    }
}