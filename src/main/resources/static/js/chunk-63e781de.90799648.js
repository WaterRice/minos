(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-63e781de"],{"0b2e":function(t,e,i){"use strict";i.r(e);var s=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-app",[i("home-toolbar"),i("v-container",[i("v-layout",{attrs:{"justify-center":""}},[i("v-flex",[i("v-timeline",[i("v-timeline-item",{attrs:{color:"deep-purple lighten-4",large:""},scopedSlots:t._u([{key:"opposite",fn:function(){return[i("span",[t._v("可以选用其他的编程语言吗?")])]},proxy:!0}])},[i("v-card",{staticClass:"elevation-2",attrs:{color:"deep-purple lighten-4"}},[i("v-card-title",{staticClass:"headline"},[t._v("目前可用语言")]),i("v-card-text",[t._v("由于技术实力原因,目前仅支持JAVA语言,后续慢慢增加对其他主流语言的支持,(MINOS小组表示已菜哭")])],1)],1),i("v-timeline-item",{attrs:{color:"pink lighten-4",large:""},scopedSlots:t._u([{key:"opposite",fn:function(){return[i("span",[t._v("后台JDK版本是多少?")])]},proxy:!0}])},[i("v-card",{staticClass:"elevation-2",attrs:{color:"pink lighten-4"}},[i("v-card-title",{staticClass:"headline"},[t._v("后端JDK环境")]),i("v-card-text",[t._v("当前是oracle jdk-8u12,这意味着你只可以写不高于这个版本的java程序")])],1)],1),i("v-timeline-item",{attrs:{color:"lime lighten-3",large:""},scopedSlots:t._u([{key:"opposite",fn:function(){return[i("span",[t._v("我该怎么组织java代码呢?")])]},proxy:!0}])},[i("v-card",{staticClass:"elevation-2",attrs:{color:"lime lighten-3"}},[i("v-card-title",{staticClass:"headline"},[t._v("代码模板")]),i("v-card-text",[i("code",{staticClass:"java"},[t._v("\n                  import ... //导入你需要的包\n                  public void main(String[] args) {\n                  Scanner scanner = new Scanner(System.in);\n                  // do something\n                  }\n                ")])])],1)],1),i("v-timeline-item",{attrs:{color:"blue-grey lighten-3",large:""},scopedSlots:t._u([{key:"opposite",fn:function(){return[i("span",[t._v("发现bug怎么办?")])]},proxy:!0}])},[i("v-card",{staticClass:"elevation-2",attrs:{color:"blue-grey lighten-3"}},[i("v-card-title",{staticClass:"headline"},[t._v("bug提交")]),i("v-card-text",[t._v("\n                作者: 2534543027@qq.com,或者在\n                "),i("v-btn",{attrs:{flat:"",href:"https://github.com/WaterRice/minos_web/issues",color:"primary"}},[t._v("这里")]),t._v("提交issue.\n              ")],1)],1)],1)],1)],1)],1)],1)],1)},n=[],a=i("3936"),o={components:{HomeToolbar:a["a"]},data:function(){return{items:[{header:"Today"},{avatar:"https://cdn.vuetifyjs.com/images/lists/1.jpg",title:"Brunch this weekend?",subtitle:"<span class='text--primary'>Ali Connors</span> &mdash; I'll be in your neighborhood doing errands this weekend. Do you want to hang out?"},{divider:!0,inset:!0},{avatar:"https://cdn.vuetifyjs.com/images/lists/2.jpg",title:'Summer BBQ <span class="grey--text text--lighten-1">4</span>',subtitle:"<span class='text--primary'>to Alex, Scott, Jennifer</span> &mdash; Wish I could come, but I'm out of town this weekend."},{divider:!0,inset:!0},{avatar:"https://cdn.vuetifyjs.com/images/lists/3.jpg",title:"Oui oui",subtitle:"<span class='text--primary'>Sandra Adams</span> &mdash; Do you have Paris recommendations? Have you ever been?"},{divider:!0,inset:!0},{avatar:"https://cdn.vuetifyjs.com/images/lists/4.jpg",title:"Birthday gift",subtitle:"<span class='text--primary'>Trevor Hansen</span> &mdash; Have any ideas about what we should get Heidi for her birthday?"},{divider:!0,inset:!0},{avatar:"https://cdn.vuetifyjs.com/images/lists/5.jpg",title:"Recipe to try",subtitle:"<span class='text--primary'>Britta Holt</span> &mdash; We should eat this: Grate, Squash, Corn, and tomatillo Tacos."}]}}},r=o,l=i("2877"),c=i("6544"),d=i.n(c),h=i("7496"),p=i("8336"),m=i("b0af"),u=i("99d9"),v=i("12b2"),g=i("a523"),f=i("0e8f"),y=i("a722"),b=(i("823f"),i("58df")),_=i("6a18"),C=Object.assign||function(t){for(var e=1;e<arguments.length;e++){var i=arguments[e];for(var s in i)Object.prototype.hasOwnProperty.call(i,s)&&(t[s]=i[s])}return t},j=Object(b["a"])(_["a"]).extend({name:"v-timeline",props:{alignTop:Boolean,dense:Boolean},computed:{classes:function(){return C({"v-timeline--align-top":this.alignTop,"v-timeline--dense":this.dense},this.themeClasses)}},render:function(t){return t("div",{staticClass:"v-timeline",class:this.classes},this.$slots.default)}}),x=i("9d26"),w=i("b64a"),B=Object.assign||function(t){for(var e=1;e<arguments.length;e++){var i=arguments[e];for(var s in i)Object.prototype.hasOwnProperty.call(i,s)&&(t[s]=i[s])}return t},k=Object(b["a"])(w["a"],_["a"]).extend({name:"v-timeline-item",props:{color:{type:String,default:"primary"},fillDot:Boolean,hideDot:Boolean,icon:String,iconColor:String,large:Boolean,left:Boolean,right:Boolean,small:Boolean},computed:{hasIcon:function(){return!!this.icon||!!this.$slots.icon}},methods:{genBody:function(){return this.$createElement("div",{staticClass:"v-timeline-item__body"},this.$slots.default)},genIcon:function(){return this.$slots.icon?this.$slots.icon:this.$createElement(x["a"],{props:{color:this.iconColor,dark:!this.theme.isDark,small:this.small}},this.icon)},genInnerDot:function(){var t=this.setBackgroundColor(this.color);return this.$createElement("div",B({staticClass:"v-timeline-item__inner-dot"},t),[this.hasIcon&&this.genIcon()])},genDot:function(){return this.$createElement("div",{staticClass:"v-timeline-item__dot",class:{"v-timeline-item__dot--small":this.small,"v-timeline-item__dot--large":this.large}},[this.genInnerDot()])},genOpposite:function(){return this.$createElement("div",{staticClass:"v-timeline-item__opposite"},this.$slots.opposite)}},render:function(t){var e=[this.genBody()];return this.hideDot||e.unshift(this.genDot()),this.$slots.opposite&&e.push(this.genOpposite()),t("div",{staticClass:"v-timeline-item",class:B({"v-timeline-item--fill-dot":this.fillDot,"v-timeline-item--left":this.left,"v-timeline-item--right":this.right},this.themeClasses)},e)}}),S=Object(l["a"])(r,s,n,!1,null,null,null);e["default"]=S.exports;d()(S,{VApp:h["a"],VBtn:p["a"],VCard:m["a"],VCardText:u["b"],VCardTitle:v["a"],VContainer:g["a"],VFlex:f["a"],VLayout:y["a"],VTimeline:j,VTimelineItem:k})},"823f":function(t,e,i){}}]);
//# sourceMappingURL=chunk-63e781de.90799648.js.map