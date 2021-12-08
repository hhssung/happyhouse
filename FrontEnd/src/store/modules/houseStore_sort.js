const sortFunctions = {
  sortByAptCodeAsc: function (a, b) {
    let x = a.aptCode.toLowerCase();
    let y = b.aptCode.toLowerCase();
    if (x < y) {
      return -1;
    }
    if (x > y) {
      return 1;
    }
    return 0;
  },
  sortByAptCodeDesc: function (a, b) {
    let x = a.aptCode.toLowerCase();
    let y = b.aptCode.toLowerCase();
    if (x < y) {
      return 1;
    }
    if (x > y) {
      return -1;
    }
    return 0;
  },
  sortByAptNameAsc: function (a, b) {
    let x = a.aptName.toLowerCase();
    let y = b.aptName.toLowerCase();
    if (x < y) {
      return -1;
    }
    if (x > y) {
      return 1;
    }
    return 0;
  },
  sortByAptNameDesc: function (a, b) {
    let x = a.aptName.toLowerCase();
    let y = b.aptName.toLowerCase();
    if (x < y) {
      return 1;
    }
    if (x > y) {
      return -1;
    }
    return 0;
  },
  sortByDongNameAsc: function (a, b) {
    let x = a.dongName.toLowerCase();
    let y = b.dongName.toLowerCase();
    if (x < y) {
      return -1;
    }
    if (x > y) {
      return 1;
    }
    return 0;
  },
  sortByDongNameDesc: function (a, b) {
    let x = a.dongName.toLowerCase();
    let y = b.dongName.toLowerCase();
    if (x < y) {
      return 1;
    }
    if (x > y) {
      return -1;
    }
    return 0;
  },
  sortByNumOfFloorsAsc: function (a, b) {
    return a.numOfFloors - b.numOfFloors;
  },
  sortByNumOfFloorsDesc: function (a, b) {
    return b.numOfFloors - a.numOfFloors;
  },
  sortByRecentPriceAsc: function (a, b) {
    let x = a.recentPrice.toLowerCase();
    let y = b.recentPrice.toLowerCase();
    if (x < y) {
      return -1;
    }
    if (x > y) {
      return 1;
    }
    return 0;
  },
  sortByRecentPriceDesc: function (a, b) {
    let x = a.recentPrice.toLowerCase();
    let y = b.recentPrice.toLowerCase();
    if (x < y) {
      return 1;
    }
    if (x > y) {
      return -1;
    }
    return 0;
  },
  sortByAreaAsc: function (a, b) {
    let x = parseFloat(a.area);
    let y = parseFloat(b.area);
    if (x < y) {
      return -1;
    }
    if (x > y) {
      return 1;
    }
    return 0;
  },
  sortByAreaDesc: function (a, b) {
    let x = parseFloat(a.area);
    let y = parseFloat(b.area);
    if (x < y) {
      return 1;
    }
    if (x > y) {
      return -1;
    }
    return 0;
  },
};

export { sortFunctions };
