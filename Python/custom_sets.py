class My_Set:

    def add(self, item):
        if item not in self.items:
            self.items.append(item)

    def remove(self, item):
        if item in self.items:
            self.items.remove(item)
        else:
            raise KeyError(f"Item {item} not found.")

    

    def union(self, other):
            new_set = CustomSet(self.items)
            for item in other.items:
                new_set.add(item)
            return new_set

    def intersection(self, other):
        new_set = CustomSet()
        for item in self.items:
            if item in other.items:
                new_set.add(item)
        return new_set

