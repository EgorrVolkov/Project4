package ua.training.entity;

public class Role implements Entity<Long> {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final class RoleBuilder {
        private Long id;
        private String name;

        public RoleBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public RoleBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public Role buildRole() {
            Role role = new Role();
            role.setId(id);
            role.setName(name);
            return role;
        }
    }
}
