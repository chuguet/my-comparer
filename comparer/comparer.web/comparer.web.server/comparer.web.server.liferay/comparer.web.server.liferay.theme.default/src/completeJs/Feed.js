
(function (e) { 
	e.fn.Feed = function (t) { 
		var n = { 
				FeedUrl: "/web/comparer/blog/-/blogs/rss", 
				MaxCount: 5, 
				ShowDesc: true, 
				ShowPubDate: true, 
				CharacterLimit: 0, 
				TitleLinkTarget: "_blank" 
		}; 
		if (t) { 
			e.extend(n, t) 
		} 
		var r = e(this).attr("id"); 
		var i; 
		e.ajax({
			type: "GET",
			url: decodeURIComponent(n.FeedUrl),
			dataType: "xml", 
			success: function (xml) {
				e("#" + r).empty(); 
				var s = ""; 
				
				 $(xml).find('entry').each(function(){
					 s += '<li><div class="itemTitle"><a href="' + $(this).find('id').text() + '" target="' + n.TitleLinkTarget + '" >' + $(this).find('title').text() + "</a></div>";
					 if (n.ShowPubDate) {
							i = new Date($(this).find('published').text()); 
							s += '<div class="itemDate">' + i.toLocaleDateString() + "</div>" 
						}
					 if (n.ShowDesc) { 
							if (n.DescCharacterLimit > 0 && $(this).find('summary').text().length > n.DescCharacterLimit) { 
									s += '<div class="itemContent">' + $(this).find('summary').text().substr(0, n.DescCharacterLimit) + "...</div>" 
							} else { 
								s += '<div class="itemContent">' + $(this).find('summary').text() + "</div>" 
							}
					}
		                
		                
		          });
				e("#" + r).append('<ul class="feedList">' + s + "</ul>") } }) } })(jQuery)
