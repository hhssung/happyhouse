<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show><h3>요소수 재고 현황</h3></b-alert>
      </b-col>
    </b-row>
    <b-row> <div id="map" class="map"></div> </b-row>
  </b-container>
</template>

<script>
import { mapState, mapActions } from "vuex";
import { mapUtils } from "@/util/mapUtil.js";

const mapStore = "mapStore";

export default {
  name: "mapDetail",
  data() {
    return {
      map: null,
      markers: [],
      infoWindows: [],
    };
  },
  created() {
    this.getYososuList();
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=" +
        mapUtils.appkey;
      document.head.appendChild(script);
    }
  },
  computed: {
    ...mapState(mapStore, ["yososuInfo"]),
  },
  methods: {
    ...mapActions(mapStore, ["getYososuList"]),
    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(36.450701, 126.570667),
        level: 13,
      };
      this.map = new kakao.maps.Map(container, options);
      this.displayMarker();
    },
    displayMarker() {
      if (!this.map) {
        return;
      }
      if (this.markers.length > 0) {
        this.markers.forEach((marker) => marker.setMap(null));
      }
      const positions = this.yososuInfo.map(
        (info) => new kakao.maps.LatLng(info.lat, info.lng)
      );
      if (positions.length > 0) {
        this.markers = positions.map(
          (position) =>
            new kakao.maps.Marker({
              map: this.map,
              position,
            })
        );
        this.infoWindows = this.yososuInfo.map(
          (info) =>
            new kakao.maps.InfoWindow({
              content: this.makeContent(info),
              removable: true,
              disableAutoPan: false,
            })
        );
        for (var i = 0; i < positions.length; i++) {
          kakao.maps.event.addListener(
            this.markers[i],
            "click",
            this.makeClickListener(
              this.map,
              this.markers[i],
              this.infoWindows[i]
            )
          );
        }
      }
    },
    makeClickListener(map, marker, infowindow) {
      return function () {
        infowindow.open(map, marker);
      };
    },
    // infoWindow에 띄울 문장 만드는 method
    makeContent(info) {
      var result = "";
      result += '<div class="test"><span class="info-title">';
      result += "<div class='test'>주유소 상세 정보</div><hr>";
      result += this.makeDiv("주소", info.address);
      result += this.makeDiv("가격", info.cost);
      result += this.makeDiv("주유소 이름", info.name);
      result += this.makeDiv("영업시간", info.openingHours);
      result += this.makeDiv("전화번호", info.phone);
      result += this.makeDiv("재고", info.stock + " 개");
      result += "</span></div>";

      return result;
    },
    makeDiv(key, value) {
      var result = "";
      result += "<span>" + key + " : </span>";
      result += "<span class='info-detail'>" + value + "<br></span>";
      return result;
    },
  },
};
</script>

<style scope>
.map {
  width: 100%;
  height: 800px;
  margin: auto;
}
.info-title {
  display: block;
  background: #888f9b;
  color: #fff;
  text-align: left;
  width: 100%;
  border-radius: 10px;
  padding: 0px 10px;
}
.info-detail {
  color: rgb(145, 255, 0);
}
.test {
  width: 100%;
  text-align: center;
}
</style>
