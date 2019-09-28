''' 
From Gokking Book pg. 146
'''
 
def solution():
    states_needed = set(["id", "nv", "ut", "wa", "id",
                          "mt", "or", "nv", "ca", "nv", "ut", "ca", "az"])
    stations = {}
    stations["kone"] = set(["id", "nv", "ut"])
    stations["ktwo"] = set(["wa", "id", "mt"])
    stations["kthree"] = set(["or", "nv", "ca"])
    stations["kfour"] = set(["nv", "ut"])
    stations["kfive"] = set(["ca", "az"])
   
    final_stations = set()
    while states_needed:
        best_stations = None
        states_covered = set()
        for station, states in stations.items():
            covered = states_needed & states
            if (len(covered) > len(states_covered)):
                best_stations = station
                states_covered = covered
                states_needed -= states_covered
                final_stations.add(best_stations)

    return final_stations


if __name__ == '__main__':
    print(solution())
