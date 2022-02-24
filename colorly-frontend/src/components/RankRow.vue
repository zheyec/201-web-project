<template>
    <td>{{ therank.owner.username }}</td>
    <td><a :href="'http://localhost:8080/userscart?id=' + therank.id">Outfit</a></td>
    <td>{{ therank.likes }}</td>

    <div class="clearfloat"></div>
</template>

<script>
export default {
    name: "RankRow",
    props: {
        therank: Object,
    },
};
</script>

<style scope>
.rank-row {
    float: left;
}

.row {
    float: left;
}
</style>
