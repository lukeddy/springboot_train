		function click_nav_menu(obj_node) {
			url = $(obj_node).attr("href");
			if (url.length > 0 && url!="#") {
				node = $(obj_node).attr("node");
				set_cookie("current_node", node);
			} else {
				//node = $(obj_node).parent().find("ul li a:first").attr("node");
				//set_cookie("current_node", node);
				//url = $(obj_node).parent().find("ul li a:first").attr("href");
				//if (url !== undefined) {
				//	location.href = url;
				//}
				//return false;
			}
		}

		/*设置 cookie*/
		function set_cookie(key, value, exp, path, domain, secure) {
			path = "/";
			var cookie_string = key + "=" + escape(value);
			if (exp) {
				cookie_string += "; expires=" + exp.toGMTString();
			}
			if (path)
				cookie_string += "; path=" + escape(path);
			if (domain)
				cookie_string += "; domain=" + escape(domain);
			if (secure)
				cookie_string += "; secure";
			document.cookie = cookie_string;
		}

		/*读取 cookie*/
		function get_cookie(cookie_name) {
			var results = document.cookie.match('(^|;) ?' + cookie_name + '=([^;]*)(;|$)');
			if (results)
				return (unescape(results[2]));
			else
				return null;
		}

		/*删除 cookie*/
		function del_cookie(cookie_name) {
			var cookie_date = new Date();
			//current date & time
			cookie_date.setTime(cookie_date.getTime() - 1);
			document.cookie = cookie_name += "=; expires=" + cookie_date.toGMTString();
		}
		
		$(document).ready(function() {
			$(".sidebar .nav a").click(function() {
				click_nav_menu($(this));
			})
			$('.ul_table .tbody input[type=checkbox]').removeAttr('checked');
			$('.ul_table').delegate('.tbody input[type=checkbox]', 'click', function() {
				$(this).closest('.tbody').toggleClass('selected');
				if (this.checked)
					ul_table.display_bar(1);
				//display action toolbar when a message is selected
				else {
					ul_table.display_bar($('.ul_table input[type=checkbox]:checked').length);
					//determine number of selected messages and display/hide action toolbar accordingly
				}
			});

			$('#id-toggle-all').removeAttr('checked').on('click', function() {
				if (this.checked) {
					ul_table.select_all();
				} else
					ul_table.select_none();
			});
			breadcrumb="";
			current_node = get_cookie("current_node");
			$(".sidebar .nav a[node='" + current_node + "']").parents("li").each(function(index,element){
				if (index > 0) {
					$(this).addClass("active open");
				} else {
					$(this).addClass("active");
				}
				breadcrumb='<li>'+$(this).find("a:first").text()+'</li>'+breadcrumb;					
			});
			
			$(".breadcrumb").append(breadcrumb);		
		}); 	