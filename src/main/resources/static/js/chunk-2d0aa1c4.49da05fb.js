(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0aa1c4"],{"102a":function(t,a,e){"use strict";e.r(a);var i=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("v-app",{attrs:{id:"inspire"}},[e("div",{staticClass:"text-xs-center"},[e("v-dialog",{attrs:{width:"300"},model:{value:t.dialog2,callback:function(a){t.dialog2=a},expression:"dialog2"}},[e("v-card",[e("v-card-title",{staticClass:"headline grey lighten-2",attrs:{"primary-title":""}},[t._v("确认登出吗?")]),e("v-card-text",{staticClass:"primary--text"},[t._v("感谢使用,祝您生活愉快!")]),e("v-divider"),e("v-card-actions",[e("v-spacer"),e("v-btn",{attrs:{color:"pink",flat:""},on:{click:t.out}},[t._v("确认")])],1)],1)],1)],1),e("v-navigation-drawer",{attrs:{clipped:t.$vuetify.breakpoint.lgAndUp,fixed:"",app:""},model:{value:t.drawer,callback:function(a){t.drawer=a},expression:"drawer"}},[e("v-list",{attrs:{dense:""}},[t._l(t.items,function(a){return[e("v-list-tile",{key:a.text,attrs:{to:"/admin"+a.link,append:""}},[e("v-list-tile-action",[e("v-icon",{attrs:{color:"primary"}},[t._v(t._s(a.icon))])],1),e("v-list-tile-content",[e("v-list-tile-title",{staticClass:"primary--text"},[t._v(t._s(a.text))])],1)],1)]}),e("v-list-tile",[e("v-list-tile-action",[e("v-icon",{attrs:{color:"primary"}},[t._v("arrow_back")])],1),e("v-list-tile-content",{on:{click:function(a){t.dialog2=!0}}},[e("v-list-tile-title",{staticClass:"primary--text"},[t._v("系统登出")])],1)],1)],2)],1),e("v-toolbar",{attrs:{"clipped-left":t.$vuetify.breakpoint.lgAndUp,color:"indigo darken-3",dark:"",app:"",fixed:""}},[e("v-toolbar-title",{staticClass:"ml-0 pl-3",staticStyle:{width:"300px"}},[e("v-toolbar-side-icon",{on:{click:function(a){a.stopPropagation(),t.drawer=!t.drawer}}}),e("span",{staticClass:"hidden-sm-and-down"},[t._v("MINOS")])],1),e("v-text-field",{staticClass:"hidden-sm-and-down",attrs:{flat:"","solo-inverted":"","hide-details":"","prepend-inner-icon":"search",label:"Search"}}),e("v-spacer"),e("v-btn",{attrs:{icon:""}},[e("v-icon",[t._v("apps")])],1),e("v-btn",{attrs:{icon:""}},[e("v-icon",[t._v("notifications")])],1),e("v-btn",{attrs:{icon:"",large:""}},[e("v-avatar",{attrs:{size:"32px",tile:""}},[e("img",{attrs:{src:"https://cdn.vuetifyjs.com/images/logos/logo.svg",alt:"Vuetify"}})])],1)],1),e("v-content",[e("v-container",{attrs:{fluid:""}},[e("router-view",{on:{plan:t.handlePlan}})],1)],1),e("v-btn",{attrs:{fab:"",bottom:"",right:"",color:"pink",dark:"",fixed:""},on:{click:function(a){t.dialog=!t.dialog}}},[e("v-icon",[t._v("add")])],1),e("v-dialog",{attrs:{width:"600px"},model:{value:t.dialog,callback:function(a){t.dialog=a},expression:"dialog"}},[e("v-container",{staticStyle:{"max-width":"600px","background-color":"#fff"}},[e("v-text-field",{attrs:{label:"What are you working on?",solo:""},on:{keydown:function(a){return!a.type.indexOf("key")&&t._k(a.keyCode,"enter",13,a.key,"Enter")?null:t.create(a)}},model:{value:t.task,callback:function(a){t.task=a},expression:"task"}},[e("v-fade-transition",{attrs:{slot:"append"},slot:"append"},[t.task?e("v-icon",{on:{click:t.create}},[t._v("add_circle")]):t._e()],1)],1),e("h2",{staticClass:"display-1 info--text pl-3"},[t._v("\n        今日任务: \n        "),e("v-fade-transition",{attrs:{"leave-absolute":""}},[e("span",{key:"tasks-"+t.tasks.length},[t._v(t._s(t.tasks.length))])])],1),e("v-divider",{staticClass:"mt-3"}),e("v-layout",{attrs:{"my-1":"","align-center":""}},[e("strong",{staticClass:"mx-3 error--text text--darken-3"},[t._v("未完成: "+t._s(t.remainingTasks))]),e("v-divider",{attrs:{vertical:""}}),e("strong",{staticClass:"mx-3 primary--text"},[t._v("已完成: "+t._s(t.completedTasks))]),e("v-spacer"),e("v-progress-circular",{staticClass:"mr-2",attrs:{value:t.progress}})],1),e("v-divider",{staticClass:"mb-3"}),t.tasks.length>0?e("v-card",[e("v-slide-y-transition",{staticClass:"py-0",attrs:{group:""}},[t._l(t.tasks,function(a,i){return[0!==i?e("v-divider",{key:i+"-divider"}):t._e(),e("v-list-tile",{key:i+"-"+a.text},[e("v-list-tile-action",[e("v-checkbox",{attrs:{color:"info darken-3"},model:{value:a.done,callback:function(e){t.$set(a,"done",e)},expression:"task.done"}},[e("div",{staticClass:"ml-3",class:a.done?"grey--text":"text--primary",attrs:{slot:"label"},domProps:{textContent:t._s(a.text)},slot:"label"})])],1),e("v-spacer"),e("v-scroll-x-transition",[a.done?e("v-icon",{attrs:{color:"success"}},[t._v("check")]):t._e()],1)],1)]})],2)],1):t._e()],1)],1)],1)},s=[],n={data:function(){return{dialog2:!1,dialog:!1,drawer:null,items:[{icon:"home",text:"课程管理",link:"/subjectManagement"},{icon:"history",text:"教师管理",link:"/teacherManagement"},{icon:"help",text:"学生管理",link:"/studentManagement"},{icon:"home",text:"问题管理",link:"/problemManagement"}],tasks:[],task:null}},computed:{completedTasks:function(){return this.tasks.filter(function(t){return t.done}).length},progress:function(){return this.completedTasks/this.tasks.length*100},remainingTasks:function(){return this.tasks.length-this.completedTasks}},methods:{dosomething:function(){},handlePlan:function(){this.dialog=!0},out:function(){this.dialog2=!1,this.$router.push("/admin/login")},create:function(){this.tasks.push({done:!1,text:this.task}),this.task=null}},props:{source:String}},o=n,r=e("2877"),l=e("6544"),c=e.n(l),d=e("7496"),v=e("8212"),p=e("8336"),u=e("b0af"),k=e("99d9"),g=e("12b2"),f=e("ac7c"),m=e("a523"),h=e("549c"),x=e("169a"),b=e("ce7e"),_=e("0789"),y=e("132d"),V=e("a722"),C=e("8860"),w=e("ba95"),T=e("40fe"),S=e("5d23"),A=e("f774"),L=e("490a"),M=e("9910"),P=e("2677"),$=e("71d9"),j=e("706c"),D=e("2a7f"),I=Object(r["a"])(o,i,s,!1,null,null,null);a["default"]=I.exports;c()(I,{VApp:d["a"],VAvatar:v["a"],VBtn:p["a"],VCard:u["a"],VCardActions:k["a"],VCardText:k["b"],VCardTitle:g["a"],VCheckbox:f["a"],VContainer:m["a"],VContent:h["a"],VDialog:x["a"],VDivider:b["a"],VFadeTransition:_["c"],VIcon:y["a"],VLayout:V["a"],VList:C["a"],VListTile:w["a"],VListTileAction:T["a"],VListTileContent:S["a"],VListTileTitle:S["c"],VNavigationDrawer:A["a"],VProgressCircular:L["a"],VScrollXTransition:_["d"],VSlideYTransition:_["f"],VSpacer:M["a"],VTextField:P["a"],VToolbar:$["a"],VToolbarSideIcon:j["a"],VToolbarTitle:D["b"]})}}]);
//# sourceMappingURL=chunk-2d0aa1c4.49da05fb.js.map