(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-7c5e7f22"],{"0094":function(t,a,s){},"2db4":function(t,a,s){"use strict";s("0094");var e=s("b64a"),i=s("98a1"),o=s("c22b"),r=s("58df");a["a"]=Object(r["a"])(e["a"],i["a"],Object(o["b"])(["absolute","top","bottom","left","right"])).extend({name:"v-snackbar",props:{autoHeight:Boolean,multiLine:Boolean,timeout:{type:Number,default:6e3},vertical:Boolean},data:function(){return{activeTimeout:-1}},computed:{classes:function(){return{"v-snack--active":this.isActive,"v-snack--absolute":this.absolute,"v-snack--auto-height":this.autoHeight,"v-snack--bottom":this.bottom||!this.top,"v-snack--left":this.left,"v-snack--multi-line":this.multiLine&&!this.vertical,"v-snack--right":this.right,"v-snack--top":this.top,"v-snack--vertical":this.vertical}}},watch:{isActive:function(){this.setTimeout()}},mounted:function(){this.setTimeout()},methods:{setTimeout:function(){var t=this;window.clearTimeout(this.activeTimeout),this.isActive&&this.timeout&&(this.activeTimeout=window.setTimeout(function(){t.isActive=!1},this.timeout))}},render:function(t){return t("transition",{attrs:{name:"v-snack-transition"}},this.isActive&&[t("div",{staticClass:"v-snack",class:this.classes,on:this.$listeners},[t("div",this.setBackgroundColor(this.color,{staticClass:"v-snack__wrapper"}),[t("div",{staticClass:"v-snack__content"},this.$slots.default)])])])}})},"50da":function(t,a,s){"use strict";s.r(a);var e=function(){var t=this,a=t.$createElement,s=t._self._c||a;return s("v-app",[s("home-toolbar"),s("v-container",[s("v-layout",{attrs:{wrap:"","justify-center":""}},[s("v-flex",[s("v-card",{attrs:{tile:"",flat:""}},[s("v-card-title",{staticClass:"primary--text",attrs:{"primary-title":""}},[t._v("题目描述:")]),s("v-flex",{attrs:{md9:""}},[s("v-card-text",{domProps:{innerHTML:t._s(t.problem.descb)}})],1)],1),s("v-card",{attrs:{tile:"",flat:""}},[s("v-card-title",{staticClass:"primary--text",attrs:{"primary-title":""}},[t._v("输入样例:")]),s("v-flex",{attrs:{md9:""}},[s("v-card-text",{staticStyle:{"letter-spacing":"6px"},domProps:{innerHTML:t._s(t.problem.input)}})],1)],1),s("v-card",{attrs:{tile:"",flat:""}},[s("v-card-title",{staticClass:"primary--text",attrs:{"primary-title":""}},[t._v("输出样例:")]),s("v-flex",{attrs:{md9:""}},[s("v-card-text",{staticStyle:{"letter-spacing":"6px"},domProps:{innerHTML:t._s(t.problem.output)}})],1),s("v-card",{attrs:{tile:"",flat:""}},[s("v-card-title",{staticClass:"primary--text",attrs:{"primary-title":""}},[t._v("编辑代码:")]),s("v-flex",{attrs:{md3:""}},[s("v-select",{attrs:{items:t.items,label:"请选择语言",solo:""}})],1),s("v-textarea",{attrs:{rows:"20",solo:"",flat:"",label:"edit your code here",color:"white",dark:""},model:{value:t.code,callback:function(a){t.code=a},expression:"code"}})],1),s("v-container",[s("v-layout",[s("v-flex",{attrs:{md3:""}},[s("v-btn",{staticClass:"white--text",attrs:{color:"primary",loading:t.loading},on:{click:t.submit}},[t._v("提交")])],1),s("v-flex",{attrs:{md9:""}},[s("v-btn",{attrs:{flat:"",color:"orange",to:"/board"}},[t._v("去瞅瞅榜单:)")])],1)],1)],1)],1)],1)],1)],1),s("v-snackbar",{attrs:{bottom:"",color:t.msgBar.color},model:{value:t.msgBar.show,callback:function(a){t.$set(t.msgBar,"show",a)},expression:"msgBar.show"}},[t._v("\n    "+t._s(t.msgBar.msg)+"\n    "),s("v-btn",{attrs:{color:"white",flat:""},on:{click:function(a){t.show=!1}}},[t._v("关闭")])],1)],1)},i=[],o=s("3936"),r={props:["id"],components:{HomeToolbar:o["a"]},data:function(){return{msgBar:{show:!1,msg:"",color:null},problem:{id:1001,title:"a+b",content:"计算a+b的值",input:"7 8",output:"15"},code:"",items:["Java","C++","C","Python","Go"],loading:!1}},methods:{submit:function(){var t=this;this.loading=!0;var a=this,s={problemId:a.id,content:a.code,language:0};this.$postRequest("/student/codesubmissions",s).then(function(a){1==a.data?t.showMsg("正确通过所有样例","teal"):t.showMsg("未通过所有测试样例","error"),t.loading=!1})},showMsg:function(t,a){this.msgBar.color=a,this.msgBar.msg=t,this.msgBar.show=!0}},mounted:function(){var t=this;this.$getRequest("/problems/"+this.id).then(function(a){t.problem=a.data})}},n=r,c=s("2877"),l=s("6544"),u=s.n(l),v=s("7496"),d=s("8336"),m=s("b0af"),h=s("99d9"),p=s("12b2"),b=s("a523"),f=s("0e8f"),g=s("a722"),w=s("b56d"),k=s("2db4"),x=s("a844"),y=Object(c["a"])(n,e,i,!1,null,null,null);a["default"]=y.exports;u()(y,{VApp:v["a"],VBtn:d["a"],VCard:m["a"],VCardText:h["b"],VCardTitle:p["a"],VContainer:b["a"],VFlex:f["a"],VLayout:g["a"],VSelect:w["a"],VSnackbar:k["a"],VTextarea:x["a"]})}}]);
//# sourceMappingURL=chunk-7c5e7f22.fb41c381.js.map