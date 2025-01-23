var __classPrivateFieldSet = (this && this.__classPrivateFieldSet) || function (receiver, state, value, kind, f) {
    if (kind === "m") throw new TypeError("Private method is not writable");
    if (kind === "a" && !f) throw new TypeError("Private accessor was defined without a setter");
    if (typeof state === "function" ? receiver !== state || !f : !state.has(receiver)) throw new TypeError("Cannot write private member to an object whose class did not declare it");
    return (kind === "a" ? f.call(receiver, value) : f ? f.value = value : state.set(receiver, value)), value;
};
var __classPrivateFieldGet = (this && this.__classPrivateFieldGet) || function (receiver, state, kind, f) {
    if (kind === "a" && !f) throw new TypeError("Private accessor was defined without a getter");
    if (typeof state === "function" ? receiver !== state || !f : !state.has(receiver)) throw new TypeError("Cannot read private member from an object whose class did not declare it");
    return kind === "m" ? f : kind === "a" ? f.call(receiver) : f ? f.value : state.get(receiver);
};
var _Voiture_km, _Voiture_marque, _Voiture_modele;
var Voiture = /** @class */ (function () {
    function Voiture(km, marque, modele) {
        _Voiture_km.set(this, void 0);
        _Voiture_marque.set(this, void 0);
        _Voiture_modele.set(this, void 0);
        __classPrivateFieldSet(this, _Voiture_km, km, "f");
        __classPrivateFieldSet(this, _Voiture_marque, marque, "f");
        __classPrivateFieldSet(this, _Voiture_modele, modele, "f");
    }
    Voiture.prototype.toString = function () {
        return "km : ".concat(__classPrivateFieldGet(this, _Voiture_km, "f"), " marque : ").concat(__classPrivateFieldGet(this, _Voiture_marque, "f"), " modele : ").concat(__classPrivateFieldGet(this, _Voiture_marque, "f"), " ");
    };
    Voiture.prototype.getKm = function () {
        return __classPrivateFieldGet(this, _Voiture_km, "f");
    };
    return Voiture;
}());
_Voiture_km = new WeakMap(), _Voiture_marque = new WeakMap(), _Voiture_modele = new WeakMap();
var mazda = new Voiture(100, "mazda", "6");
console.log(mazda.toString());
