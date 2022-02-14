<template>
    <div id="header"><Header></Header></div>

    <router-view></router-view>
</template>

<script>
import Header from "./components/Header.vue";

export default {
    name: "App",
    components: {
        Header,
    },
};
</script>

<style>
#header {
    margin-top: 0px;
    padding-top: 0px;
}
.sidebar {
    padding-top: 100px;
    width: 220px;
    float: left;
    height: 100%; /* Full-height: remove this if you want "auto" height */
    width: 160px; /* Set the width of the sidebar */
    /* position: fixed; Fixed Sidebar (stay in place on scroll) */
    z-index: 1; /* Stay on top */
    top: 0; /* Stay at the top */
    left: 0;
    /* box-shadow: black; */
}

.mainArea {
    width: 60%;
    /* top: 0px; */
    /* z-index: 1; */
    float: left;
    margin-left: 220px;
    margin-top: 0px;
}

#app {
    /* background-color: turquoise; */
    padding-top: 0px;
    margin-top: 0px;
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
}

.itemCard {
    float: left;
}

.clearfloat {
    float: none;
}
</style>
