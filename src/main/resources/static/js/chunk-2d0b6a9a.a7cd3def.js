(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0b6a9a"],{"1db3":function(e,t,r){"use strict";r.r(t);var o=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("v-container",[r("v-layout",{attrs:{wrap:""}},[r("v-flex",{attrs:{md7:""}},[r("v-select",{attrs:{items:e.subjects,label:"请选择课程",rules:[e.rules.required]}})],1),r("v-flex",{attrs:{md7:""}},[r("v-text-field",{attrs:{label:"作业标题",rules:[e.rules.required,e.rules.max10]},model:{value:e.homework.title,callback:function(t){e.$set(e.homework,"title",t)},expression:"homework.title"}})],1),r("v-flex",{attrs:{md7:""}},[r("v-menu",{ref:"menu",attrs:{"close-on-content-click":!1,"nudge-right":40,"return-value":e.homework.to,lazy:"",transition:"scale-transition","offset-y":"","full-width":"","min-width":"290px"},on:{"update:returnValue":function(t){return e.$set(e.homework,"to",t)},"update:return-value":function(t){return e.$set(e.homework,"to",t)}},model:{value:e.menu,callback:function(t){e.menu=t},expression:"menu"}},[r("v-text-field",{attrs:{slot:"activator",label:"截止日期",rules:[e.rules.required]},slot:"activator",model:{value:e.homework.to,callback:function(t){e.$set(e.homework,"to",t)},expression:"homework.to"}}),r("v-date-picker",{attrs:{"no-title":"",scrollable:""},model:{value:e.homework.to,callback:function(t){e.$set(e.homework,"to",t)},expression:"homework.to"}},[r("v-spacer"),r("v-btn",{attrs:{flat:"",color:"primary"},on:{click:function(t){e.menu=!1}}},[e._v("Cancel")]),r("v-btn",{attrs:{flat:"",color:"primary"},on:{click:function(t){return e.$refs.menu.save(e.homework.to)}}},[e._v("OK")])],1)],1)],1),r("v-flex",{attrs:{md7:""}},[r("v-textarea",{attrs:{label:"作业内容",hint:"编写作业内容",rules:[e.rules.required,e.rules.max300]},model:{value:e.homework.descb,callback:function(t){e.$set(e.homework,"descb",t)},expression:"homework.descb"}})],1),r("v-flex",{attrs:{md7:""}},[r("v-textarea",{attrs:{label:"作业要求",hint:"编写作业要求",rules:[e.rules.required,e.rules.max300]},model:{value:e.homework.repu,callback:function(t){e.$set(e.homework,"repu",t)},expression:"homework.repu"}})],1),r("br"),r("br"),r("v-flex",{staticStyle:{"text-align":"center"},attrs:{md7:""}},[r("v-btn",{attrs:{tile:"",color:"primary"},on:{click:e.submit}},[e._v("提交")])],1)],1)],1)},a=[],l={data:function(){return{homework:{title:"",descb:"",repu:"",to:"",subject_id:0},menu:!1,subjects:["高等数学","抽象代数","离散数学","数据结构","计算机网络"],rules:{required:function(e){return!!e||"必填字段"},max10:function(e){return e.length<=10||"不得超过10个字符"},max300:function(e){return e.length<=300||"不得超过300个字符"}}}},methods:{submit:function(){console.log(this.homework.descb)}}},n=l,u=r("2877"),s=r("6544"),c=r.n(s),i=r("8336"),m=r("a523"),d=r("2e4b"),k=r("0e8f"),f=r("a722"),v=r("e449"),b=r("b56d"),h=r("9910"),w=r("2677"),x=r("a844"),p=Object(u["a"])(n,o,a,!1,null,null,null);t["default"]=p.exports;c()(p,{VBtn:i["a"],VContainer:m["a"],VDatePicker:d["a"],VFlex:k["a"],VLayout:f["a"],VMenu:v["a"],VSelect:b["a"],VSpacer:h["a"],VTextField:w["a"],VTextarea:x["a"]})}}]);
//# sourceMappingURL=chunk-2d0b6a9a.a7cd3def.js.map