package vn.edu.iuh.fit.quanlythuocwithtomcat.entities;

public enum State {
    Y("Còn hạn"),N("Hết han");
    private String state;
    private State(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
}
