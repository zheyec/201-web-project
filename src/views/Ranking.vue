<template>
    <div class="mainpage">
        <h1>Outfit Leaderboard</h1>

        <div class="table-wrapper">
            <table class="table">
                <div class="table-header">
                    <thead>
                        <tr>
                            <th>Rank</th>
                            <th>Author</th>
                            <th>Link</th>
                            <th>Likes</th>
                        </tr>
                    </thead>
                </div>

                <tbody>
                    <div :key="rank.id" v-for="rank in rankings">
                        <tr>
                            <td></td>
                            <RankRow :therank="rank" />
                        </tr>
                    </div>
                </tbody>
            </table>
        </div>
    </div>
    <div class="clearfloat"></div>
</template>

<script>
import RankRow from "../components/RankRow.vue";

export default {
    name: "Ranking",
    data() {
        return {
            rankings: [],
        };
    },
    components: {
        RankRow,
    },

    async created() {
        var url = "http://localhost:8081/outfits/popular";
        const response = await fetch(url, {
            method: "GET",
        });

        if (response.status == 200) {
            this.rankings = await response.json();
        } else {
            alert((await response.json()).error);
        }
    },
};
</script>

<style>
.mainpage {
    width: 100%;

    /* top: 0px; */
    /* z-index: 1; */
    float: left;
    clear: both;
    font-size: 0.75rem;
    align-content: center;
    margin-left: auto;
    margin-top: auto;
    margin-right: auto;
    margin-bottom: auto;
    width: 100%;
    font-family: Helvetica;
    -webkit-font-smoothing: antialiased;
}

* {
    box-sizing: border-box;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
}

tbody tr td:first-child::before {
    content: counter(rowNumber);
    min-width: 1em;
    margin-right: 0.5em;
}

tbody {
    counter-reset: rowNumber;
}

tbody tr {
    counter-increment: rowNumber;
}

.table {
    border-radius: 6px;
    font-size: 15px;
    font-weight: normal;
    border: none;
    border-collapse: collapse;
    width: 100%;
    white-space: nowrap;
    background-color: white;
    display: block;
    align-content: center;
    display: block;
}

.tableheader {
    padding: auto;
    width: 100%;
    align-content: center;
}

.table td,
.table th {
    text-align: center;
    padding: 8px;
}

.table td {
    border-right: 1px solid #f8f8f8;
    font-size: 12px;
}

.table thead th {
    color: #ffffff;
    background: #4fc3a1;
    margin: auto;
}

.table thead th:nth-child(odd) {
    color: #ffffff;
    background: #324960;
}

.table tr:nth-child(even) {
    background: #f8f8f8;
}

.table thead th:last-child {
    border-bottom: none;
}

.table-wrapper {
    align-content: center;
    box-shadow: 0px 35px 50px rgba(0, 0, 0, 0.2);
    position: absolute;
    left: 25%;
}

.table td,
.table th {
    padding: 20px 0.625em 0.625em 0.625em;
    height: 60px;
    vertical-align: middle;
    align-content: center;
    box-sizing: border-box;
    overflow-x: hidden;
    overflow-y: auto;
    min-width: 150px;
    width: auto;
    font-size: 13px;
    text-overflow: ellipsis;
}

@media (max-width: 767px) {
    .table {
        display: block;
        width: 100%;
    }
    .table-wrapper:before {
        content: "Scroll horizontally >";
        display: block;
        text-align: right;
        font-size: 11px;
        color: white;
        padding: 0 0 10px;
    }

    .table thead,
    .table tbody,
    .table thead th {
        display: block;
    }
    .table thead th:last-child {
        border-bottom: none;
    }
    .table thead {
        float: left;
    }
    .table tbody {
        width: auto;
        position: relative;
        overflow-x: auto;
    }

    .table thead th {
        text-align: left;
        border-bottom: 1px solid #f7f7f9;
    }
    .table tbody tr {
        display: table-cell;
    }
    .table tbody td {
        display: block;
        text-align: center;
    }
}
</style>
