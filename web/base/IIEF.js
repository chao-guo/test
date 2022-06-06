(function(global, factory){
    typeof exports === 'object' && typeof module !== 'undefined' ? module.exports = factory() :
        typeof define === 'function' && define.amd ? define(factory) :
            (global.Chao = factory());
}(this,(function(){
    function coutFunction(v) {
        console.log("function",v);
    }
    function Chao(){
        console.log("Chao 实例化");
    }
    Chao.prototype.coutFun = coutFunction;
    return Chao;
})));