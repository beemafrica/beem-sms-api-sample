using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace SMSAPI.Models
{
    public class SMSCallback
    {
        [Key]
        public Int64 id { get; set; }
        public string request_id { get; set; }
        public string recipient_id { get; set; }
        public string dest_addr { get; set; }
        public string Status { get; set; }
    }
}
