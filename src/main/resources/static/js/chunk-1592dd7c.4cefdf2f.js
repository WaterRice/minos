(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-1592dd7c"],{"0094":function(t,e,a){},"2db4":function(t,e,a){"use strict";a("0094");var s=a("b64a"),i=a("98a1"),r=a("c22b"),o=a("58df");e["a"]=Object(o["a"])(s["a"],i["a"],Object(r["b"])(["absolute","top","bottom","left","right"])).extend({name:"v-snackbar",props:{autoHeight:Boolean,multiLine:Boolean,timeout:{type:Number,default:6e3},vertical:Boolean},data:function(){return{activeTimeout:-1}},computed:{classes:function(){return{"v-snack--active":this.isActive,"v-snack--absolute":this.absolute,"v-snack--auto-height":this.autoHeight,"v-snack--bottom":this.bottom||!this.top,"v-snack--left":this.left,"v-snack--multi-line":this.multiLine&&!this.vertical,"v-snack--right":this.right,"v-snack--top":this.top,"v-snack--vertical":this.vertical}}},watch:{isActive:function(){this.setTimeout()}},mounted:function(){this.setTimeout()},methods:{setTimeout:function(){var t=this;window.clearTimeout(this.activeTimeout),this.isActive&&this.timeout&&(this.activeTimeout=window.setTimeout(function(){t.isActive=!1},this.timeout))}},render:function(t){return t("transition",{attrs:{name:"v-snack-transition"}},this.isActive&&[t("div",{staticClass:"v-snack",class:this.classes,on:this.$listeners},[t("div",this.setBackgroundColor(this.color,{staticClass:"v-snack__wrapper"}),[t("div",{staticClass:"v-snack__content"},this.$slots.default)])])])}})},"50da":function(t,e,a){"use strict";a.r(e);var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("v-app",[a("home-toolbar"),a("v-container",[a("v-layout",{attrs:{wrap:"","justify-center":""}},[a("v-flex",[a("v-card",{attrs:{tile:"",flat:""}},[a("v-card-title",{staticClass:"primary--text",attrs:{"primary-title":""}},[t._v("题目描述:")]),a("pre",[t._v("          "),a("v-flex",{attrs:{md9:""}},[t._v("\n            "),a("v-card-text",{domProps:{innerHTML:t._s(t.problem.descb)}}),t._v("\n          ")],1),t._v("\n          ")],1)],1),a("v-card",{attrs:{tile:"",flat:""}},[a("v-card-title",{staticClass:"primary--text",attrs:{"primary-title":""}},[t._v("输入样例:")]),a("v-flex",{attrs:{md9:""}},[a("pre",[t._v("            "),a("v-card-text",{staticStyle:{"letter-spacing":"6px"},domProps:{innerHTML:t._s(t.problem.inputExample)}}),t._v("\n            ")],1)])],1),a("v-card",{attrs:{tile:"",flat:""}},[a("v-card-title",{staticClass:"primary--text",attrs:{"primary-title":""}},[t._v("输出样例:")]),a("v-flex",{attrs:{md9:""}},[a("pre",[t._v("            "),a("v-card-text",{staticStyle:{"letter-spacing":"6px"},domProps:{innerHTML:t._s(t.problem.outputExample)}}),t._v("\n            ")],1)]),a("v-card",{attrs:{tile:"",flat:""}},[a("v-card-title",{staticClass:"primary--text",attrs:{"primary-title":""}},[t._v("编辑代码:")]),a("v-flex",{attrs:{md3:""}},[a("v-select",{attrs:{items:t.items,label:"请选择语言",solo:""}})],1),a("v-textarea",{attrs:{rows:"20",solo:"",flat:"",label:"edit your code here",color:"white",dark:""},model:{value:t.code,callback:function(e){t.code=e},expression:"code"}})],1),a("v-container",[a("v-layout",[a("v-flex",{attrs:{md3:""}},[a("v-btn",{staticClass:"white--text",attrs:{color:"primary",loading:t.loading},on:{click:t.submit}},[t._v("提交")])],1),a("v-flex",{attrs:{md9:""}},[a("v-btn",{attrs:{flat:"",color:"orange",to:"/board"}},[t._v("去瞅瞅榜单:)")])],1)],1)],1)],1)],1)],1)],1),a("v-snackbar",{attrs:{bottom:"",color:t.msgBar.color},model:{value:t.msgBar.show,callback:function(e){t.$set(t.msgBar,"show",e)},expression:"msgBar.show"}},[t._v("\n    "+t._s(t.msgBar.msg)+"\n    "),a("v-btn",{attrs:{color:"white",flat:""},on:{click:function(e){t.show=!1}}},[t._v("关闭")])],1)],1)},i=[],r=a("e814"),o=a.n(r),n=a("3936"),c={props:["id"],components:{HomeToolbar:n["a"]},data:function(){return{msgBar:{show:!1,msg:"",color:null},problem:{id:0,title:"",content:"",inputExample:"",outputExample:""},code:"",items:["Java","C++","C","Python","Go"],loading:!1}},methods:{submit:function(){var t=this;this.loading=!0;var e=this,a={problemId:o()(e.id),content:e.code,language:0};this.$postRequest("/student/codesubmissions",a).then(function(e){1==e.data?t.showMsg("正确通过所有样例","teal"):t.showMsg("未通过所有测试样例","error"),t.loading=!1})},showMsg:function(t,e){this.msgBar.color=e,this.msgBar.msg=t,this.msgBar.show=!0}},mounted:function(){var t=this;this.$getRequest("/problems/"+this.id).then(function(e){t.problem=e.data})}},l=c,u=a("2877"),v=a("6544"),m=a.n(v),d=a("7496"),p=a("8336"),h=a("b0af"),f=a("99d9"),b=a("12b2"),g=a("a523"),x=a("0e8f"),w=a("a722"),_=a("b56d"),k=a("2db4"),y=a("a844"),C=Object(u["a"])(l,s,i,!1,null,null,null);e["default"]=C.exports;m()(C,{VApp:d["a"],VBtn:p["a"],VCard:h["a"],VCardText:f["b"],VCardTitle:b["a"],VContainer:g["a"],VFlex:x["a"],VLayout:w["a"],VSelect:_["a"],VSnackbar:k["a"],VTextarea:y["a"]})},"5d6b":function(t,e,a){var s=a("e53d").parseInt,i=a("a1ce").trim,r=a("e692"),o=/^[-+]?0[xX]/;t.exports=8!==s(r+"08")||22!==s(r+"0x16")?function(t,e){var a=i(String(t),3);return s(a,e>>>0||(o.test(a)?16:10))}:s},7445:function(t,e,a){var s=a("63b6"),i=a("5d6b");s(s.G+s.F*(parseInt!=i),{parseInt:i})},a1ce:function(t,e,a){var s=a("63b6"),i=a("25eb"),r=a("294c"),o=a("e692"),n="["+o+"]",c="​",l=RegExp("^"+n+n+"*"),u=RegExp(n+n+"*$"),v=function(t,e,a){var i={},n=r(function(){return!!o[t]()||c[t]()!=c}),l=i[t]=n?e(m):o[t];a&&(i[a]=l),s(s.P+s.F*n,"String",i)},m=v.trim=function(t,e){return t=String(i(t)),1&e&&(t=t.replace(l,"")),2&e&&(t=t.replace(u,"")),t};t.exports=v},b9e9:function(t,e,a){a("7445"),t.exports=a("584a").parseInt},e692:function(t,e){t.exports="\t\n\v\f\r   ᠎             　\u2028\u2029\ufeff"},e814:function(t,e,a){t.exports=a("b9e9")}}]);
//# sourceMappingURL=chunk-1592dd7c.4cefdf2f.js.map