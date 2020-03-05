$(function() {
	var awardId = getQueryString('awardId');
	var awardUrl = '/myo2o/shopadmin/getawardbyid?awardId='
			+ awardId;

	$
			.getJSON(
				awardUrl,
					function(data) {
						if (data.success) {
							var award = data.award;
							$('#awardImg').attr('src', award.awardImg);
							$('#award-create-time').text(
									new Date(award.createTime)
											.Format("yyyy-MM-dd"));
							$('#award-expire-time').text(
								new Date(award.expireTime)
									.Format("yyyy-MM-dd"));
							$('#award-name').text(award.awardName);
							$('#award-desc').text(award.awardDesc);
							var textOp = "不可用";
							var contraryStatus = 0;
							if (award.enableStatus == 1) {
								textOp = "可用";
								contraryStatus = 1;
							} else {
								contraryStatus = 0;
							}
							$('#award-status').text(textOp);
						}
					});
	$('#me').click(function() {
		$.openPanel('#panel-left-demo');
	});
	$.init();
});
