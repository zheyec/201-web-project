<template>
    <div class="outterCircle">
        <!--not sure if this shti works-->
        <button
            :style="{ background: colorInfo.colorHexCode }"
            @click="onClick"
            class="unClickedIconBtn"
            :value="colorInfo.colorHexCode"
        ></button>
    </div>
</template>

<script>
export default {
    name: "popularColorIcon",
    props: {
        colorInfo: Object,
    },
    methods: {
        onClick(e) {
            let data = { colorId: this.colorInfo.id, elem: e.target };
            this.$emit("selected-popular-color", data); // send selected color to upper level widget to send API to backend for query
        },
    },
};
</script>

<style scoped>
.selected {
    border-color: red;
}

.unClickedIconBtn {
    height: 25px;
    width: 25px;
    /* background-color:  var(colorInfo.colorHexCode); */
    border-radius: 50%;
    display: inline-block;
}

.outterCircle {
    padding-top: 2px;
    height: 27px;
    width: 27px;
    float: left;
    margin-left: 10px;
    margin-right: 10px;
    background-color: transparent;
    border: 2px solid white;

    border-radius: 50%;
    display: inline-block;
}
</style>
