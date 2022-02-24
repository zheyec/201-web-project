import { createRouter, createWebHistory } from "vue-router";
// Add Additional Imports of Home and MyCart Later
import Home from "../views/Home.vue";
import MyCart from "../views/MyCart.vue";
import Community from "../views/Community.vue";
import Ranking from "../views/Ranking.vue";
import Userscart from "../views/Userscart.vue";
import SignIn from "../views/SignIn.vue";
import CreateAccount from "../views/CreateAccount.vue";

const routes = [
    {
        path: "/",
        name: "Home",
        component: Home,
    },
    {
        path: "/mycart",
        name: "MyCart",
        component: MyCart,
    },
    {
        path: "/community",
        name: "Community",
        component: Community,
    },
    {
        path: "/ranking",
        name: "Ranking",
        component: Ranking,
    },
    {
        path: "/signin",
        name: "SignIn",
        component: SignIn,
    },
    {
        path: "/create",
        name: "CreateAccount",
        component: CreateAccount,
    },
    {
        path: "/userscart",
        name: "Userscart",
        component: Userscart,
    },
];

console.log(process.env.BASE_URL);

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes,
});

export default router;
