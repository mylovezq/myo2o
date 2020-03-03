/**
 * Created by cheng on 2018/3/31.
 */

//全局变量 命名空间
var common = window.common || {};

/**
 * 验证码生成
 */
common.changeVerifyCode = function (img) {
    img.src = '/myo2o/Kaptcha?' + Math.floor(Math.random() * 100);
};


/**
 * 获取查询 字符串
 */
common.getQueryString = function (name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return decodeURIComponent(r[2]);
    }
    return '';
};


/**
 * 初始化 picker
 */
common.initPicker = function (data, picker, defaultIndex) {
    // 单列picker
    weui.picker(data, {
        container: 'body',
        defaultValue: [defaultIndex ? defaultIndex : data[0].value],
        onConfirm: function (result) {
            picker.html(result[0].label);
            picker.pickerId = result[0].value;
        },
        id: picker[0].id
    });
};

/**
 * 图片控件
 * 图片上传(只是前端页面展示功能，并没有真正的上传)
 * 缩略图预览控件
 */
common.imgShow = function (maxCount) {
    var uploadCount = 0,
        uploadList = [],
        $upload_count = $('#uploadCount');

    // 图片上传控件
    weui.uploader('#uploader', {
        auto: false,
        type: 'file',
        onBeforeQueued: function onBeforeQueued() {
            if (['image/jpg', 'image/jpeg', 'image/png', 'image/gif'].indexOf(this.type) < 0) {
                weui.alert('请上传图片');
                return false;
            }
            if (this.size > 10 * 1024 * 1024) {
                weui.alert('请上传不超过10M的图片');
                return false;
            }
            if (uploadCount + 1 > maxCount) {
                weui.alert('最多只能上传' + maxCount + '张图片');
                return false;
            }

            ++uploadCount;
            uploadList.push(this);
            $upload_count.html(uploadCount);
        }
    });

    // 缩略图预览
    $('#uploaderFiles').on('click', function (e) {

        if (uploadCount === 0) {
            return;
        }

        var target = e.target;

        while (!target.classList.contains('weui-uploader__file') && target) {
            target = target.parentNode;
        }
        if (!target) return;

        var url = target.getAttribute('style') || '',
            id = target.getAttribute('data-id');

        if (url) {
            url = url.match(/url\((.*?)\)/)[1].replace(/"/g, '');
        }

        var gallery = weui.gallery(url, {
            className: 'custom-name',
            onDelete: function onDelete() {
                weui.confirm('确定删除该图片？', function () {
                    target.remove();
                    gallery.hide();

                    uploadList.pop(id);
                    --uploadCount;
                    $upload_count.html(uploadCount);
                });
            }
        });
    });

    return uploadList;
};


/**
 * 对Date的扩展，将 Date 转化为指定格式的String
 * 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
 */
Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for (var k in o) {
        if (new RegExp("(" + k + ")").test(fmt)) {
            fmt = fmt.replace(RegExp.$1,
                (RegExp.$1.length === 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }
    return fmt;
};