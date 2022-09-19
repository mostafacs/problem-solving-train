
from collections import defaultdict, deque


def no_parents(children, N):
    nodes = set(range(1, N + 1))
    for num in children:
        if num in nodes:
            nodes.remove(num)
    return list(nodes)


def get_fun(children, fun_factors, parents, N):
    q = deque([[node, fun_factors[node - 1]] for node in no_parents(children, N)])

    ans = 0
    mp = defaultdict(list)

    while q:
        curr, maxi = q.pop()
        if not curr:
            ans += maxi
            continue

        mp[curr].append(maxi)

        if curr not in parents or parents[curr] == len(mp[curr]):
            maxi = max(maxi, fun_factors[curr - 1])

            if len(mp[curr]) == 1:
                q.appendleft([children[curr - 1], maxi])
            else:
                total = sum(mp[curr])
                mini = min(mp[curr])

                ans += total - mini
                q.appendleft([children[curr - 1], max(mini, fun_factors[curr - 1])])

    return ans


if __name__ == "__main__":
    test_cases = int(input())
    res = []
    for test_case in range(1, test_cases + 1):
        N = int(input())
        f = [int(x) for x in input().split(" ")]
        c = [int(x) for x in input().split(" ")]
        p = defaultdict(int)
        for idx, n in enumerate(c):
            p[n] += 1

        fun = get_fun(c, f, p, N)

        res.append(f"Case #{test_case}: {fun}")

    print("\n".join(res))
