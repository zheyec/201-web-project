<template>
    <div id="whole">
        <!-- <popularColorIcon :colorCode="colorCode" /> -->
        <div id="popularColorSection">
            <p>Color Boxes:</p>
            <div class="colorDiv">
                <div :key="colorData.id" v-for="colorData in popularColorDatas">
                    <popularColorIcon
                        @selected-popular-color="setColorBox"
                        :colorInfo="colorData"
                    ></popularColorIcon>
                </div>
            </div>
            <div class="clearfloat"></div>
        </div>

        <br />

        <div id="colorPickerSection">
            <p>Change Color Box:</p>
            <div :style="{ background: color }">
                <colorPicker
                    :color="color"
                    :sucker-hide="false"
                    :sucker-canvas="suckerCanvas"
                    :sucker-area="suckerArea"
                    @changeColor="changeColor"
                    @openSucker="openSucker"
                />
            </div>
        </div>

        <button v-on:click="applyClicked" id="searchButton">Apply</button>
    </div>
</template>

<script>
import popularColorIcon from "./popularColorIcon.vue";
import colorPicker from "@caohenghu/vue-colorpicker";
export default {
    components: {
        popularColorIcon,
        colorPicker,
    },
    name: "pickColorSection",
    data() {
        return {
            // colorCode: '#ff5678',
            color: "#ffffff",
            suckerCanvas: null,
            suckerArea: [],
            isSucking: false,
            chosenColorBox: null,
            lastId: null,
            lastElem: null,
            // colorSelected: [] // Not sure if needed
        };
    },
    props: {
        popularColorDatas: Array,
    },
    methods: {
        async applyClicked() {
            let colors = this.popularColorDatas.map(
                (colorBox) => colorBox.colorHexCode
            );
            this.$emit("query-selected-colors", colors);
        },
        setColorBox(data) {
            if (data.colorId == this.lastId) {
                this.lastId = null;
                this.chosenColorBox = null;
                this.lastElem = null;
                return data.elem.classList.remove("selected");
            }
            this.chosenColorBox = this.popularColorDatas[data.colorId - 1];
            this.lastId = data.colorId;
            data.elem.classList.add("selected");
            if (this.lastElem) {
                this.lastElem.classList.remove("selected");
            }
            this.lastElem = data.elem;
        },
        changeColor(color) {
            if (!this.chosenColorBox) {
                return alert("Choose a color box first!");
            }
            this.chosenColorBox.colorHexCode = color.hex;
            this.color = color.hex;
        },
        openSucker(isOpen) {
            if (isOpen) {
                console.log("IDK WTF this function is for");
                // ... canvas be created
                // this.suckerCanvas = canvas
                // this.suckerArea = [x1, y1, x2, y2]
            } else {
                // this.suckerCanvas && this.suckerCanvas.remove
                console.log("not open? WTF does it mean?");
            }
        },
    },
};
</script>

<style scoped>
#searchButton {
    cursor: pointer;
    margin-top: 80px;
    height: 40px;
    width: 100px;
    background-color: black;
    color: white;
    border-radius: 10px;
}
#whole {
    float: left;
    /* width: 400px; */
    width: 218px;
}
#popularIconSection {
    padding-left: 50px;
    margin-left: 30px;
    text-align: left;
    margin-top: 50px;
    margin-bottom: 100px;
    padding-bottom: 100px;
    /* width: 200px; */
}
.clearfloat {
    float: none;
}
#colorPickerSection {
    padding-top: 30px;
    margin-left: 15px;
}
.colorDiv {
    display: flex;
    justify-content: center;
}
</style>
