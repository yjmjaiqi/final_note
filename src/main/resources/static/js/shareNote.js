// 共享笔记
function shareNote() {
    Array.from(document.getElementsByClassName("shareValue")).forEach(i => {
        i.onclick = function () {
            let id = this.getAttribute("value");
            $.ajax({url: "/shareNote/share_id?id=" + id, async: false});
            alert("笔记共享成功")
            const data = $.ajax({url: "/note/page?currentPage=" + currentPage, async: false});
            const json = JSON.parse(data.responseText);
            console.log("jsons=" + json)
            let success = '';
            let banner = '';
            for (const note in json) {
                success += '<div id="bw">\n' +
                    '            <div>\n' +
                    '                <div id="cbody_bar_r">\n' +
                    '                   <span><b>双击笔记共享</b><a onclick="cancelUser()" style="color: #2ac87e" class="cancelShare" value="' + json[note].id + '">取消共享]</a> ' +
                    '                                          <a onclick="shareUser()" style="color: #2ac87e" class="shareValue" value="' + json[note].id + '">[共享用户|</a> ' +
                    '                                          <a onclick="cancelClass()" style="color: #007aff" class="cancelShare" value="' + json[note].id + '">取消共享]</a> ' +
                    '                                          <a onclick="shareClass()" style="color: #007aff" class="shareValue" value="' + json[note].id + '">[共享班级|</a> ' +
                    '                                          <a onclick="cancelAcademy()" style="color: #8a6de9" class="cancelShare" value="' + json[note].id + '">取消共享]</a> ' +
                    '                                          <a onclick="shareAcademy()" style="color: #8a6de9" class="shareValue" value="' + json[note].id + '">[共享院校|</a> ' +
                    '                                          <a onclick="cancelShare()" style="color: #f0ad4e" class="cancelShare" value="' + json[note].id + '">|取消共享笔记]</a> ' +
                    '                                          <a onclick="shareNote()" style="color: #f0ad4e" class="shareValue" value="' + json[note].id + '">[点我共享笔记</a> ' +
                    '                                    </span>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '\n' +
                    '            <div class="bw_text">\n' +
                    '                <a class="bw_text_title" href="#">' + json[note].note_title + '</a>\n' +
                    '                <span class="title_span">发表时间:' + json[note].note_time + '</span>\n' +
                    '                <a href="#">\n' +
                    '                    <input style="background-color: cyan" type="button" value="[编辑]" class="bw_text_title_bt" target="_self">\n' +
                    '                </a>\n' +
                    '                <a href="/note/deleteNote?id=' + json[note].id + '">\n' +
                    '                    <input style="background-color: red" type="button" value="[删除]" class="bw_text_title_bt" target="_self">\n' +
                    '                </a>\n' +
                    '                <a href="/note/alterNote?id=' + json[note].id + '">\n' +
                    '                    <input style="background-color: greenyellow" type="button" value="[修改万物]" class="bw_text_title_bt" target="_self">\n' +
                    '                </a>\n' +
                    '\n' +
                    '                <br/>\n' +
                    '                <br>\n' +
                    '                <br>\n' +
                    '                <div class="text_text">' + json[note].note_content + '</div>\n' +
                    '            </div>\n' +
                    '            <br/>\n' +
                    '            <hr class="bw_hr">\n' +
                    '\n' +
                    '            <br/>\n' +
                    '            <br/>\n' +
                    '            <br/>\n' +
                    '</div>'
                banner += '                  <ul>\n' +
                    '                            <img class="fk_img" src="../img/costomer.png">\n' +
                    '                            <li>' + json[note].note_title + '</li>\n' +
                    '                            <span class="fk_time">修改时间:' + json[note].alter_time + '</span>\n' +
                    '                        </ul>\n' +
                    '                        <br>'
            }
            $(".banner_as").html(banner);
            $(".cbody_right").html(success);
            document.getElementById("currentPage").innerHTML = currentPage;
        }
    })
}

// 取消共享
function cancelShare() {
    Array.from(document.getElementsByClassName("cancelShare")).forEach(i => {
        i.onclick = function () {
            let id = this.getAttribute("value");
            $.ajax({url: "/shareNote/cancelShare_id?id=" + id, async: false});
            alert("取消共享笔记")
            const data = $.ajax({url: "/note/page?currentPage=" + currentPage, async: false});
            const json = JSON.parse(data.responseText);
            console.log("jsons=" + json)
            let success = '';
            let banner = '';
            for (const note in json) {
                success += '<div id="bw">\n' +
                    '            <div>\n' +
                    '                <div id="cbody_bar_r">\n' +
                    '                   <span><b>双击笔记共享</b><a onclick="cancelUser()" style="color: #2ac87e" class="cancelShare" value="' + json[note].id + '">取消共享]</a> ' +
                    '                                          <a onclick="shareUser()" style="color: #2ac87e" class="shareValue" value="' + json[note].id + '">[共享用户|</a> ' +
                    '                                          <a onclick="cancelClass()" style="color: #007aff" class="cancelShare" value="' + json[note].id + '">取消共享]</a> ' +
                    '                                          <a onclick="shareClass()" style="color: #007aff" class="shareValue" value="' + json[note].id + '">[共享班级|</a> ' +
                    '                                          <a onclick="cancelAcademy()" style="color: #8a6de9" class="cancelShare" value="' + json[note].id + '">取消共享]</a> ' +
                    '                                          <a onclick="shareAcademy()" style="color: #8a6de9" class="shareValue" value="' + json[note].id + '">[共享院校|</a> ' +
                    '                                          <a onclick="cancelShare()" style="color: #f0ad4e" class="cancelShare" value="' + json[note].id + '">|取消共享笔记]</a> ' +
                    '                                          <a onclick="shareNote()" style="color: #f0ad4e" class="shareValue" value="' + json[note].id + '">[点我共享笔记</a> ' +
                    '                                    </span>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '\n' +
                    '            <div class="bw_text">\n' +
                    '                <a class="bw_text_title" href="#">' + json[note].note_title + '</a>\n' +
                    '                <span class="title_span">发表时间:' + json[note].note_time + '</span>\n' +
                    '                <a href="#">\n' +
                    '                    <input style="background-color: cyan" type="button" value="[编辑]" class="bw_text_title_bt" target="_self">\n' +
                    '                </a>\n' +
                    '                <a href="/note/deleteNote?id=' + json[note].id + '">\n' +
                    '                    <input style="background-color: red" type="button" value="[删除]" class="bw_text_title_bt" target="_self">\n' +
                    '                </a>\n' +
                    '                <a href="/note/alterNote?id=' + json[note].id + '">\n' +
                    '                    <input style="background-color: greenyellow" type="button" value="[修改万物]" class="bw_text_title_bt" target="_self">\n' +
                    '                </a>\n' +
                    '\n' +
                    '                <br/>\n' +
                    '                <br>\n' +
                    '                <br>\n' +
                    '                <div class="text_text">' + json[note].note_content + '</div>\n' +
                    '            </div>\n' +
                    '            <br/>\n' +
                    '            <hr class="bw_hr">\n' +
                    '\n' +
                    '            <br/>\n' +
                    '            <br/>\n' +
                    '            <br/>\n' +
                    '</div>'
                banner += '                  <ul>\n' +
                    '                            <img class="fk_img" src="../img/costomer.png">\n' +
                    '                            <li>' + json[note].note_title + '</li>\n' +
                    '                            <span class="fk_time">修改时间:' + json[note].alter_time + '</span>\n' +
                    '                        </ul>\n' +
                    '                        <br>'
            }
            $(".banner_as").html(banner);
            $(".cbody_right").html(success);
            document.getElementById("currentPage").innerHTML = currentPage;
        }
    })
}

// 共享院校
function shareAcademy() {
    Array.from(document.getElementsByClassName("shareValue")).forEach(i => {
        i.onclick = function () {
            let id = this.getAttribute("value");
            const AcademyName = prompt("输入指定共享院校");
            const msg = $.ajax({url: "/shareNote/toacademy?id=" + id + "&academyName=" + AcademyName, async: false});
            alert(msg.responseText)
            const data = $.ajax({url: "/note/page?currentPage=" + currentPage, async: false});
            const json = JSON.parse(data.responseText);
            console.log("jsons=" + json)
            let success = '';
            let banner = '';
            for (const note in json) {
                success += '<div id="bw">\n' +
                    '            <div>\n' +
                    '                <div id="cbody_bar_r">\n' +
                    '                   <span><b>双击笔记共享</b><a onclick="cancelUser()" style="color: #2ac87e" class="cancelShare" value="' + json[note].id + '">取消共享]</a> ' +
                    '                                          <a onclick="shareUser()" style="color: #2ac87e" class="shareValue" value="' + json[note].id + '">[共享用户|</a> ' +
                    '                                          <a onclick="cancelClass()" style="color: #007aff" class="cancelShare" value="' + json[note].id + '">取消共享]</a> ' +
                    '                                          <a onclick="shareClass()" style="color: #007aff" class="shareValue" value="' + json[note].id + '">[共享班级|</a> ' +
                    '                                          <a onclick="cancelAcademy()" style="color: #8a6de9" class="cancelShare" value="' + json[note].id + '">取消共享]</a> ' +
                    '                                          <a onclick="shareAcademy()" style="color: #8a6de9" class="shareValue" value="' + json[note].id + '">[共享院校|</a> ' +
                    '                                          <a onclick="cancelShare()" style="color: #f0ad4e" class="cancelShare" value="' + json[note].id + '">|取消共享笔记]</a> ' +
                    '                                          <a onclick="shareNote()" style="color: #f0ad4e" class="shareValue" value="' + json[note].id + '">[点我共享笔记</a> ' +
                    '                                    </span>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '\n' +
                    '            <div class="bw_text">\n' +
                    '                <a class="bw_text_title" href="#">' + json[note].note_title + '</a>\n' +
                    '                <span class="title_span">发表时间:' + json[note].note_time + '</span>\n' +
                    '                <a href="#">\n' +
                    '                    <input style="background-color: cyan" type="button" value="[编辑]" class="bw_text_title_bt" target="_self">\n' +
                    '                </a>\n' +
                    '                <a href="/note/deleteNote?id=' + json[note].id + '">\n' +
                    '                    <input style="background-color: red" type="button" value="[删除]" class="bw_text_title_bt" target="_self">\n' +
                    '                </a>\n' +
                    '                <a href="/note/alterNote?id=' + json[note].id + '">\n' +
                    '                    <input style="background-color: greenyellow" type="button" value="[修改万物]" class="bw_text_title_bt" target="_self">\n' +
                    '                </a>\n' +
                    '\n' +
                    '                <br/>\n' +
                    '                <br>\n' +
                    '                <br>\n' +
                    '                <div class="text_text">' + json[note].note_content + '</div>\n' +
                    '            </div>\n' +
                    '            <br/>\n' +
                    '            <hr class="bw_hr">\n' +
                    '\n' +
                    '            <br/>\n' +
                    '            <br/>\n' +
                    '            <br/>\n' +
                    '</div>'
                banner += '                  <ul>\n' +
                    '                            <img class="fk_img" src="../img/costomer.png">\n' +
                    '                            <li>' + json[note].note_title + '</li>\n' +
                    '                            <span class="fk_time">修改时间:' + json[note].alter_time + '</span>\n' +
                    '                        </ul>\n' +
                    '                        <br>'
            }
            $(".banner_as").html(banner);
            $(".cbody_right").html(success);
            document.getElementById("currentPage").innerHTML = currentPage;
        }
    })
}

// 取消共享
function cancelAcademy() {
    Array.from(document.getElementsByClassName("cancelShare")).forEach(i => {
        i.onclick = function () {
            let id = this.getAttribute("value");
            const AcademyName = prompt("输入指定共享院校");
            const msg = $.ajax({
                url: "/shareNote/cancelAcademy?academyName=" + AcademyName + "&id=" + id,
                async: false
            });
            alert(msg.responseText)
            const data = $.ajax({url: "/note/page?currentPage=" + currentPage, async: false});
            const json = JSON.parse(data.responseText);
            console.log("jsons=" + json)
            let success = '';
            let banner = '';
            for (const note in json) {
                success += '<div id="bw">\n' +
                    '            <div>\n' +
                    '                <div id="cbody_bar_r">\n' +
                    '                   <span><b>双击笔记共享</b><a onclick="cancelUser()" style="color: #2ac87e" class="cancelShare" value="' + json[note].id + '">取消共享]</a> ' +
                    '                                          <a onclick="shareUser()" style="color: #2ac87e" class="shareValue" value="' + json[note].id + '">[共享用户|</a> ' +
                    '                                          <a onclick="cancelClass()" style="color: #007aff" class="cancelShare" value="' + json[note].id + '">取消共享]</a> ' +
                    '                                          <a onclick="shareClass()" style="color: #007aff" class="shareValue" value="' + json[note].id + '">[共享班级|</a> ' +
                    '                                          <a onclick="cancelAcademy()" style="color: #8a6de9" class="cancelShare" value="' + json[note].id + '">取消共享]</a> ' +
                    '                                          <a onclick="shareAcademy()" style="color: #8a6de9" class="shareValue" value="' + json[note].id + '">[共享院校|</a> ' +
                    '                                          <a onclick="cancelShare()" style="color: #f0ad4e" class="cancelShare" value="' + json[note].id + '">|取消共享笔记]</a> ' +
                    '                                          <a onclick="shareNote()" style="color: #f0ad4e" class="shareValue" value="' + json[note].id + '">[点我共享笔记</a> ' +
                    '                                    </span>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '\n' +
                    '            <div class="bw_text">\n' +
                    '                <a class="bw_text_title" href="#">' + json[note].note_title + '</a>\n' +
                    '                <span class="title_span">发表时间:' + json[note].note_time + '</span>\n' +
                    '                <a href="#">\n' +
                    '                    <input style="background-color: cyan" type="button" value="[编辑]" class="bw_text_title_bt" target="_self">\n' +
                    '                </a>\n' +
                    '                <a href="/note/deleteNote?id=' + json[note].id + '">\n' +
                    '                    <input style="background-color: red" type="button" value="[删除]" class="bw_text_title_bt" target="_self">\n' +
                    '                </a>\n' +
                    '                <a href="/note/alterNote?id=' + json[note].id + '">\n' +
                    '                    <input style="background-color: greenyellow" type="button" value="[修改万物]" class="bw_text_title_bt" target="_self">\n' +
                    '                </a>\n' +
                    '\n' +
                    '                <br/>\n' +
                    '                <br>\n' +
                    '                <br>\n' +
                    '                <div class="text_text">' + json[note].note_content + '</div>\n' +
                    '            </div>\n' +
                    '            <br/>\n' +
                    '            <hr class="bw_hr">\n' +
                    '\n' +
                    '            <br/>\n' +
                    '            <br/>\n' +
                    '            <br/>\n' +
                    '</div>'
                banner += '                  <ul>\n' +
                    '                            <img class="fk_img" src="../img/costomer.png">\n' +
                    '                            <li>' + json[note].note_title + '</li>\n' +
                    '                            <span class="fk_time">修改时间:' + json[note].alter_time + '</span>\n' +
                    '                        </ul>\n' +
                    '                        <br>'
            }
            $(".banner_as").html(banner);
            $(".cbody_right").html(success);
            document.getElementById("currentPage").innerHTML = currentPage;
        }
    })
}

// 共享班级
function shareClass() {
    Array.from(document.getElementsByClassName("shareValue")).forEach(i => {
        i.onclick = function () {
            let id = this.getAttribute("value");
            const className = prompt("输入指定共享班级");
            const msg = $.ajax({url: "/shareNote/toclass?id=" + id + "&className=" + className, async: false});
            alert(msg.responseText)
            const data = $.ajax({url: "/note/page?currentPage=" + currentPage, async: false});
            const json = JSON.parse(data.responseText);
            console.log("jsons=" + json)
            let success = '';
            let banner = '';
            for (const note in json) {
                success += '<div id="bw">\n' +
                    '            <div>\n' +
                    '                <div id="cbody_bar_r">\n' +
                    '                   <span><b>双击笔记共享</b><a onclick="cancelUser()" style="color: #2ac87e" class="cancelShare" value="' + json[note].id + '">取消共享]</a> ' +
                    '                                          <a onclick="shareUser()" style="color: #2ac87e" class="shareValue" value="' + json[note].id + '">[共享用户|</a> ' +
                    '                                          <a onclick="cancelClass()" style="color: #007aff" class="cancelShare" value="' + json[note].id + '">取消共享]</a> ' +
                    '                                          <a onclick="shareClass()" style="color: #007aff" class="shareValue" value="' + json[note].id + '">[共享班级|</a> ' +
                    '                                          <a onclick="cancelAcademy()" style="color: #8a6de9" class="cancelShare" value="' + json[note].id + '">取消共享]</a> ' +
                    '                                          <a onclick="shareAcademy()" style="color: #8a6de9" class="shareValue" value="' + json[note].id + '">[共享院校|</a> ' +
                    '                                          <a onclick="cancelShare()" style="color: #f0ad4e" class="cancelShare" value="' + json[note].id + '">|取消共享笔记]</a> ' +
                    '                                          <a onclick="shareNote()" style="color: #f0ad4e" class="shareValue" value="' + json[note].id + '">[点我共享笔记</a> ' +
                    '                                    </span>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '\n' +
                    '            <div class="bw_text">\n' +
                    '                <a class="bw_text_title" href="#">' + json[note].note_title + '</a>\n' +
                    '                <span class="title_span">发表时间:' + json[note].note_time + '</span>\n' +
                    '                <a href="#">\n' +
                    '                    <input style="background-color: cyan" type="button" value="[编辑]" class="bw_text_title_bt" target="_self">\n' +
                    '                </a>\n' +
                    '                <a href="/note/deleteNote?id=' + json[note].id + '">\n' +
                    '                    <input style="background-color: red" type="button" value="[删除]" class="bw_text_title_bt" target="_self">\n' +
                    '                </a>\n' +
                    '                <a href="/note/alterNote?id=' + json[note].id + '">\n' +
                    '                    <input style="background-color: greenyellow" type="button" value="[修改万物]" class="bw_text_title_bt" target="_self">\n' +
                    '                </a>\n' +
                    '\n' +
                    '                <br/>\n' +
                    '                <br>\n' +
                    '                <br>\n' +
                    '                <div class="text_text">' + json[note].note_content + '</div>\n' +
                    '            </div>\n' +
                    '            <br/>\n' +
                    '            <hr class="bw_hr">\n' +
                    '\n' +
                    '            <br/>\n' +
                    '            <br/>\n' +
                    '            <br/>\n' +
                    '</div>'
                banner += '                  <ul>\n' +
                    '                            <img class="fk_img" src="../img/costomer.png">\n' +
                    '                            <li>' + json[note].note_title + '</li>\n' +
                    '                            <span class="fk_time">修改时间:' + json[note].alter_time + '</span>\n' +
                    '                        </ul>\n' +
                    '                        <br>'
            }
            $(".banner_as").html(banner);
            $(".cbody_right").html(success);
            document.getElementById("currentPage").innerHTML = currentPage;
        }
    })
}

// <a style="color: #2ac87e">['+json[note].shareid+']</a>
// 取消共享
function cancelClass() {
    Array.from(document.getElementsByClassName("cancelShare")).forEach(i => {
        i.onclick = function () {
            let id = this.getAttribute("value");
            const className = prompt("输入取消指定共享班级");
            const msg = $.ajax({url: "/shareNote/cancelClass?className=" + className + "&id=" + id, async: false});
            const jsons = msg.responseText;
            console.log("jsons=" + jsons)
            alert(msg.responseText)
            const data = $.ajax({url: "/note/page?currentPage=" + currentPage, async: false});
            const json = JSON.parse(data.responseText);
            console.log("jsons=" + json)
            let success = '';
            let banner = '';
            for (const note in json) {
                success += '<div id="bw">\n' +
                    '            <div>\n' +
                    '                <div id="cbody_bar_r">\n' +
                    '                   <span><b>双击笔记共享</b><a onclick="cancelUser()" style="color: #2ac87e" class="cancelShare" value="' + json[note].id + '">取消共享]</a> ' +
                    '                                          <a onclick="shareUser()" style="color: #2ac87e" class="shareValue" value="' + json[note].id + '">[共享用户|</a> ' +
                    '                                          <a onclick="cancelClass()" style="color: #007aff" class="cancelShare" value="' + json[note].id + '">取消共享]</a> ' +
                    '                                          <a onclick="shareClass()" style="color: #007aff" class="shareValue" value="' + json[note].id + '">[共享班级|</a> ' +
                    '                                          <a onclick="cancelAcademy()" style="color: #8a6de9" class="cancelShare" value="' + json[note].id + '">取消共享]</a> ' +
                    '                                          <a onclick="shareAcademy()" style="color: #8a6de9" class="shareValue" value="' + json[note].id + '">[共享院校|</a> ' +
                    '                                          <a onclick="cancelShare()" style="color: #f0ad4e" class="cancelShare" value="' + json[note].id + '">|取消共享笔记]</a> ' +
                    '                                          <a onclick="shareNote()" style="color: #f0ad4e" class="shareValue" value="' + json[note].id + '">[点我共享笔记</a> ' +
                    '                                    </span>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '\n' +
                    '            <div class="bw_text">\n' +
                    '                <a class="bw_text_title" href="#">' + json[note].note_title + '</a>\n' +
                    '                <span class="title_span">发表时间:' + json[note].note_time + '</span>\n' +
                    '                <a href="#">\n' +
                    '                    <input style="background-color: cyan" type="button" value="[编辑]" class="bw_text_title_bt" target="_self">\n' +
                    '                </a>\n' +
                    '                <a href="/note/deleteNote?id=' + json[note].id + '">\n' +
                    '                    <input style="background-color: red" type="button" value="[删除]" class="bw_text_title_bt" target="_self">\n' +
                    '                </a>\n' +
                    '                <a href="/note/alterNote?id=' + json[note].id + '">\n' +
                    '                    <input style="background-color: greenyellow" type="button" value="[修改万物]" class="bw_text_title_bt" target="_self">\n' +
                    '                </a>\n' +
                    '\n' +
                    '                <br/>\n' +
                    '                <br>\n' +
                    '                <br>\n' +
                    '                <div class="text_text">' + json[note].note_content + '</div>\n' +
                    '            </div>\n' +
                    '            <br/>\n' +
                    '            <hr class="bw_hr">\n' +
                    '\n' +
                    '            <br/>\n' +
                    '            <br/>\n' +
                    '            <br/>\n' +
                    '</div>'
                banner += '                  <ul>\n' +
                    '                            <img class="fk_img" src="../img/costomer.png">\n' +
                    '                            <li>' + json[note].note_title + '</li>\n' +
                    '                            <span class="fk_time">修改时间:' + json[note].alter_time + '</span>\n' +
                    '                        </ul>\n' +
                    '                        <br>'
            }
            $(".banner_as").html(banner);
            $(".cbody_right").html(success);
            document.getElementById("currentPage").innerHTML = currentPage;
        }
    })
}

// 共享用户
function shareUser() {
    Array.from(document.getElementsByClassName("shareValue")).forEach(i => {
        i.onclick = function () {
            let id = this.getAttribute("value");
            const username = prompt("输入指定共享用户");
            const msg = $.ajax({url: "/shareNote/touser?id=" + id + "&username=" + username, async: false});
            const jsons = msg.responseText;
            console.log("jsons=" + jsons)
            alert(msg.responseText)
            const data = $.ajax({url: "/note/page?currentPage=" + currentPage, async: false});
            const json = JSON.parse(data.responseText);
            console.log("jsons=" + json)
            let success = '';
            let banner = '';
            for (const note in json) {
                success += '<div id="bw">\n' +
                    '            <div>\n' +
                    '                <div id="cbody_bar_r">\n' +
                    '                   <span><b>双击笔记共享</b><a onclick="cancelUser()" style="color: #2ac87e" class="cancelShare" value="' + json[note].id + '">取消共享]</a> ' +
                    '                                          <a onclick="shareUser()" style="color: #2ac87e" class="shareValue" value="' + json[note].id + '">[共享用户|</a> ' +
                    '                                          <a onclick="cancelClass()" style="color: #007aff" class="cancelShare" value="' + json[note].id + '">取消共享]</a> ' +
                    '                                          <a onclick="shareClass()" style="color: #007aff" class="shareValue" value="' + json[note].id + '">[共享班级|</a> ' +
                    '                                          <a onclick="cancelAcademy()" style="color: #8a6de9" class="cancelShare" value="' + json[note].id + '">取消共享]</a> ' +
                    '                                          <a onclick="shareAcademy()" style="color: #8a6de9" class="shareValue" value="' + json[note].id + '">[共享院校|</a> ' +
                    '                                          <a onclick="cancelShare()" style="color: #f0ad4e" class="cancelShare" value="' + json[note].id + '">|取消共享笔记]</a> ' +
                    '                                          <a onclick="shareNote()" style="color: #f0ad4e" class="shareValue" value="' + json[note].id + '">[点我共享笔记</a> ' +
                    '                                    </span>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '\n' +
                    '            <div class="bw_text">\n' +
                    '                <a class="bw_text_title" href="#">' + json[note].note_title + '</a>\n' +
                    '                <span class="title_span">发表时间:' + json[note].note_time + '</span>\n' +
                    '                <a href="#">\n' +
                    '                    <input style="background-color: cyan" type="button" value="[编辑]" class="bw_text_title_bt" target="_self">\n' +
                    '                </a>\n' +
                    '                <a href="/note/deleteNote?id=' + json[note].id + '">\n' +
                    '                    <input style="background-color: red" type="button" value="[删除]" class="bw_text_title_bt" target="_self">\n' +
                    '                </a>\n' +
                    '                <a href="/note/alterNote?id=' + json[note].id + '">\n' +
                    '                    <input style="background-color: greenyellow" type="button" value="[修改万物]" class="bw_text_title_bt" target="_self">\n' +
                    '                </a>\n' +
                    '\n' +
                    '                <br/>\n' +
                    '                <br>\n' +
                    '                <br>\n' +
                    '                <div class="text_text">' + json[note].note_content + '</div>\n' +
                    '            </div>\n' +
                    '            <br/>\n' +
                    '            <hr class="bw_hr">\n' +
                    '\n' +
                    '            <br/>\n' +
                    '            <br/>\n' +
                    '            <br/>\n' +
                    '</div>'
                banner += '                  <ul>\n' +
                    '                            <img class="fk_img" src="../img/costomer.png">\n' +
                    '                            <li>' + json[note].note_title + '</li>\n' +
                    '                            <span class="fk_time">修改时间:' + json[note].alter_time + '</span>\n' +
                    '                        </ul>\n' +
                    '                        <br>'
            }
            $(".banner_as").html(banner);
            $(".cbody_right").html(success);
            document.getElementById("currentPage").innerHTML = currentPage;
        }
    })
}

// 取消共享
function cancelUser() {
    Array.from(document.getElementsByClassName("cancelShare")).forEach(i => {
        i.onclick = function () {
            let id = this.getAttribute("value");
            const username = prompt("输入取消指定共享用户");
            const msg = $.ajax({url: "/shareNote/cancelUser?username=" + username + "&id=" + id, async: false});
            const jsons = msg.responseText;
            console.log("jsons=" + jsons)
            alert(msg.responseText)
            const data = $.ajax({url: "/note/page?currentPage=" + currentPage, async: false});
            const json = JSON.parse(data.responseText);
            console.log("jsons=" + json)
            let success = '';
            let banner = '';
            for (const note in json) {
                success += '<div id="bw">\n' +
                    '            <div>\n' +
                    '                <div id="cbody_bar_r">\n' +
                    '                   <span><b>双击笔记共享</b><a onclick="cancelUser()" style="color: #2ac87e" class="cancelShare" value="' + json[note].id + '">取消共享]</a> ' +
                    '                                          <a onclick="shareUser()" style="color: #2ac87e" class="shareValue" value="' + json[note].id + '">[共享用户|</a> ' +
                    '                                          <a onclick="cancelClass()" style="color: #007aff" class="cancelShare" value="' + json[note].id + '">取消共享]</a> ' +
                    '                                          <a onclick="shareClass()" style="color: #007aff" class="shareValue" value="' + json[note].id + '">[共享班级|</a> ' +
                    '                                          <a onclick="cancelAcademy()" style="color: #8a6de9" class="cancelShare" value="' + json[note].id + '">取消共享]</a> ' +
                    '                                          <a onclick="shareAcademy()" style="color: #8a6de9" class="shareValue" value="' + json[note].id + '">[共享院校|</a> ' +
                    '                                          <a onclick="cancelShare()" style="color: #f0ad4e" class="cancelShare" value="' + json[note].id + '">|取消共享笔记]</a> ' +
                    '                                          <a onclick="shareNote()" style="color: #f0ad4e" class="shareValue" value="' + json[note].id + '">[点我共享笔记</a> ' +
                    '                                    </span>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '\n' +
                    '            <div class="bw_text">\n' +
                    '                <a class="bw_text_title" href="#">' + json[note].note_title + '</a>\n' +
                    '                <span class="title_span">发表时间:' + json[note].note_time + '</span>\n' +
                    '                <a href="#">\n' +
                    '                    <input style="background-color: cyan" type="button" value="[编辑]" class="bw_text_title_bt" target="_self">\n' +
                    '                </a>\n' +
                    '                <a href="/note/deleteNote?id=' + json[note].id + '">\n' +
                    '                    <input style="background-color: red" type="button" value="[删除]" class="bw_text_title_bt" target="_self">\n' +
                    '                </a>\n' +
                    '                <a href="/note/alterNote?id=' + json[note].id + '">\n' +
                    '                    <input style="background-color: greenyellow" type="button" value="[修改万物]" class="bw_text_title_bt" target="_self">\n' +
                    '                </a>\n' +
                    '\n' +
                    '                <br/>\n' +
                    '                <br>\n' +
                    '                <br>\n' +
                    '                <div class="text_text">' + json[note].note_content + '</div>\n' +
                    '            </div>\n' +
                    '            <br/>\n' +
                    '            <hr class="bw_hr">\n' +
                    '\n' +
                    '            <br/>\n' +
                    '            <br/>\n' +
                    '            <br/>\n' +
                    '</div>'
                banner += '                  <ul>\n' +
                    '                            <img class="fk_img" src="../img/costomer.png">\n' +
                    '                            <li>' + json[note].note_title + '</li>\n' +
                    '                            <span class="fk_time">修改时间:' + json[note].alter_time + '</span>\n' +
                    '                        </ul>\n' +
                    '                        <br>'
            }
            $(".banner_as").html(banner);
            $(".cbody_right").html(success);
            document.getElementById("currentPage").innerHTML = currentPage;
        }
    })
}


// const data = $.ajax({url: "/note/page?currentPage=" + currentPage, async: false});
// const json = JSON.parse(data.responseText);
// console.log("jsons=" + json)
// let success = '';
// let banner = '';
// for (const note in json) {
//     success += '<div id="bw">\n' +
//         '            <div>\n' +
//         '                <div id="cbody_bar_r">\n' +
//         '                   <span><b>双击笔记共享</b><a onclick="cancelUser()" style="color: #2ac87e" class="cancelShare" value="'+json[note].id+'">取消共享]</a> ' +
//         '                                          <a onclick="shareUser()" style="color: #2ac87e" class="shareValue" value="'+json[note].id+'">[共享用户|</a> ' +
//         '                                          <a onclick="cancelClass()" style="color: #007aff" class="cancelShare" value="'+json[note].id+'">取消共享]</a> ' +
//         '                                          <a onclick="shareClass()" style="color: #007aff" class="shareValue" value="'+json[note].id+'">[共享班级|</a> ' +
//         '                                          <a onclick="cancelAcademy()" style="color: #8a6de9" class="cancelShare" value="'+json[note].id+'">取消共享]</a> ' +
//         '                                          <a onclick="shareAcademy()" style="color: #8a6de9" class="shareValue" value="'+json[note].id+'">[共享院校|</a> ' +
//         '                                          <a onclick="cancelShare()" style="color: #f0ad4e" class="cancelShare" value="'+json[note].id+'">|取消共享笔记]</a> ' +
//         '                                          <a onclick="shareNote()" style="color: #f0ad4e" class="shareValue" value="'+json[note].id+'">[点我共享笔记</a> ' +
//         '                                    </span>\n'+
//         '                </div>\n' +
//         '            </div>\n' +
//         '\n' +
//         '            <div class="bw_text">\n' +
//         '                <a class="bw_text_title" href="#">' + json[note].note_title + '</a>\n' +
//         '                <span class="title_span">发表时间:' + json[note].note_time + '</span>\n' +
//         '                <a href="#">\n' +
//         '                    <input style="background-color: cyan" type="button" value="[编辑]" class="bw_text_title_bt" target="_self">\n' +
//         '                </a>\n' +
//         '                <a href="/note/deleteNote?id=' + json[note].id + '">\n' +
//         '                    <input style="background-color: red" type="button" value="[删除]" class="bw_text_title_bt" target="_self">\n' +
//         '                </a>\n' +
//         '                <a href="/note/alterNote?id=' + json[note].id + '">\n' +
//         '                    <input style="background-color: greenyellow" type="button" value="[修改万物]" class="bw_text_title_bt" target="_self">\n' +
//         '                </a>\n' +
//         '\n' +
//         '                <br/>\n' +
//         '                <br>\n' +
//         '                <br>\n' +
//         '                <div class="text_text">' + json[note].note_content + '</div>\n' +
//         '            </div>\n' +
//         '            <br/>\n' +
//         '            <hr class="bw_hr">\n' +
//         '\n' +
//         '            <br/>\n' +
//         '            <br/>\n' +
//         '            <br/>\n' +
//         '</div>'
//     banner += '                  <ul>\n' +
//         '                            <img class="fk_img" src="../img/costomer.png">\n' +
//         '                            <li>' + json[note].note_title + '</li>\n' +
//         '                            <span class="fk_time">修改时间:' + json[note].alter_time + '</span>\n' +
//         '                        </ul>\n' +
//         '                        <br>'
// }
// $(".banner_as").html(banner);
// $(".cbody_right").html(success);
// document.getElementById("currentPage").innerHTML = currentPage;